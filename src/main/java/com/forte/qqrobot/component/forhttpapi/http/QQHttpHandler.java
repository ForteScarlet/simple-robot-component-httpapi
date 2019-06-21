package com.forte.qqrobot.component.forhttpapi.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.forte.qqrobot.ResourceDispatchCenter;
import com.forte.qqrobot.beans.messages.msgget.MsgGet;
import com.forte.qqrobot.component.forhttpapi.beans.response.msgget.HttpMsgGetType;
import com.forte.qqrobot.listener.invoker.ListenerManager;
import com.forte.qqrobot.sender.MsgSender;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.function.Function;

/**
 * qq请求处理器
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/4/4 18:11
 * @since JDK1.8
 **/
public class QQHttpHandler implements HttpHandler {

    /** 编码格式 */
    private final String ENCODING;

    /** 接收到消息JSON字符串后的消息处理类 */
//    private final Function<String, Resp> JSON_PARAM_CONSUMER;

    /** 可以接受的请求方式 */
    private final String[] METHODS;

    /** 监听器管理器，对消息进行处理 */
    private final ListenerManager listenerManager;

    /** 送信器 */
    private final HttpSender httpSender;

    /** 构造 */
    public QQHttpHandler(String encode,
                         String[] methods,
                         ListenerManager listenerManager,
                         HttpSender httpSender
                         ){
        this.ENCODING = encode;
        this.METHODS = methods;
        this.listenerManager = listenerManager;
        this.httpSender = httpSender;
    }

    /**
     * 消息接收器
     */
    @Override
    public void handle(HttpExchange httpExchange) {
        //使用线程异步接收消息
        ResourceDispatchCenter.getThreadPool().execute(() -> doHandle(httpExchange));
    }

    /**
     * 接收到消息的逻辑
     */
    private void doHandle(HttpExchange httpExchange){
        try{
            //获得表单提交数据
            //判断请求方式
            String method = httpExchange.getRequestMethod();

            //判断请求方式
            if(Arrays.stream(this.METHODS).anyMatch(m -> m.toLowerCase().equals(method.toLowerCase()))){
                //获取接收到的参数
                InputStream requestBody = httpExchange.getRequestBody();
                //编码转义
                String paramsUrl = IOUtils.toString(requestBody, ENCODING);
                String params = URLDecoder.decode(paramsUrl, ENCODING);

                //参数
                //转化为json对象并根据type值获取封装对象
                JSONObject jsonData = JSON.parseObject(params);
                jsonData.put("originalData", params);

                int type = jsonData.getInteger("type");
                HttpMsgGetType byType = HttpMsgGetType.getByType(type);
                if(byType != null){
                    MsgGet msgGet = jsonData.toJavaObject(byType.getType());
                    listenerManager.onMsg(msgGet, httpSender);
                }

                //将获取到的请求参数放入, 获得响应消息
                Resp apply = Resp.getDefaultInstance();
                int headerLeft = apply.getHeaderLeft();
                long headerRight = apply.getHeaderRight();
                String body = apply.getBody();

                // 设置响应头
                //httpExchange.getResponseHeaders().add("Content-Type", "text/html; charset=" + ENCODING);

                // 设置响应code和内容长度
                httpExchange.sendResponseHeaders(headerLeft, headerRight);

                //获取响应输出流
                OutputStream out = httpExchange.getResponseBody();
                // 响应信息
                IOUtils.write(body, out, ENCODING);

                // 关闭处理器, 同时将关闭请求和响应的输入输出流（如果还没关闭）
//                httpExchange.close();
            }
        }catch (Exception e){
            try {
                e.printStackTrace();
                // 设置响应code和内容长度
                httpExchange.sendResponseHeaders(500, 0);
                OutputStream out = httpExchange.getResponseBody();
                // 响应信息
                IOUtils.write("error", out, ENCODING);
                // 关闭处理器, 同时将关闭请求和响应的输入输出流（如果还没关闭）
//                httpExchange.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }finally{
            // 关闭处理器, 同时将关闭请求和响应的输入输出流（如果还没关闭）
            httpExchange.close();
        }
    }

}
