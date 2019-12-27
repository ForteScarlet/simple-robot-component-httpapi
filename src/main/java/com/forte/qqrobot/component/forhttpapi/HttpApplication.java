package com.forte.qqrobot.component.forhttpapi;

import com.forte.plusutils.consoleplus.console.Colors;
import com.forte.qqrobot.BaseApplication;
import com.forte.qqrobot.beans.messages.result.LoginQQInfo;
import com.forte.qqrobot.component.forhttpapi.http.*;
import com.forte.qqrobot.depend.DependCenter;
import com.forte.qqrobot.listener.invoker.ListenerManager;
import com.forte.qqrobot.log.QQLog;
import com.forte.qqrobot.log.QQLogBack;
import com.forte.qqrobot.sender.senderlist.SenderGetList;
import com.forte.qqrobot.sender.senderlist.SenderSendList;
import com.forte.qqrobot.sender.senderlist.SenderSetList;

import java.io.IOException;

/**
 * Http连接启动器
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/4/4 18:14
 * @since JDK1.8
 **/
public class HttpApplication extends BaseApplication<HttpConfiguration, HttpApiSpecialApi> {


    /** http 服务器 */
    private QQHttpServer httpServer;

    /** 送信器 */
    private HttpSender httpSender;

    /** 特殊API */
    private HttpApiSpecialApi spApi;

    /**
     * 开发者实现的资源初始化
     */
    @Override
    protected void resourceInit() {
        HttpApiResourceDispatchCenter.saveHttpConfiguration(new HttpConfiguration());
        HttpApiResourceDispatchCenter.saveQQJSONMsgCreator(new QQJSONMsgCreator());
        HttpApiResourceDispatchCenter.saveQQHttpMsgSender(QQHttpMsgSender.build());
        HttpSender httpSender = HttpSender.build();
        HttpApiResourceDispatchCenter.saveHttpSender(httpSender);
        this.httpSender = httpSender;
    }

    @Override
    protected void resourceInit(HttpConfiguration configuration){}

    /**
     * 获取消息发送接口, 将会在连接成功后使用
     */
    @Override
    protected SenderSendList getSender() {
        return httpSender;
    }

    /**
     * 获取事件设置接口, 将会在连接成功后使用
     */
    @Override
    protected SenderSetList getSetter() {
        return httpSender;
    }

    /**
     * 获取资源获取接口, 将会在连接成功后使用
     */
    @Override
    protected SenderGetList getGetter() {
        return httpSender;
    }

    /**
     * 获取真实的完整Sender对象
     */
    @Override
    public HttpApiSpecialApi getSpecialApi() {
        return spApi;
    }

    /**
     * 开发者实现的启动方法
     *
     * @param manager 监听管理器，用于分配获取到的消息
     */
    @Override
    protected String start(DependCenter center, ListenerManager manager) {
        HttpConfiguration configuration = getConfiguration();
        /*
         * 开启服务
         * @param port 端口号
         * @param listenerPath 监听地址
         * @param  backlog TCP连接最大并发数, 传 0 或负数表示使用默认值
         * @param encode 编码
         * @param msgConsumer 接收消息，然后获取返回值
         * @param methods 可以接收的消息类型
         */
        int port = configuration.getJavaPort();
        String listenerPath = configuration.getServerPath();
        int backlog = configuration.getBacklog();
        String encode = configuration.getEncode();
        String[] method = configuration.getMethod();

        // 将获取机器人信息放在构建服务端之前
        QQLog.info("尝试获取登录QQ信息...");
        try {
            getAndShowQQInfo(configuration);
        }catch (Exception e){
            QQLog.error("登录QQ信息获取失败，请确保已经手动配置或检查连接信息是否正确。", e);
        }

        try {
            this.httpServer = QQHttpServer.start(port, listenerPath, backlog, encode, method, manager, httpSender);
        } catch (IOException e) {
            throw new RuntimeException("服务端构建失败", e);
        }

        // 构建spAPI
        spApi = new HttpApiSpecialApi(httpSender, httpServer);

        return "Http Server";
    }

    /**
     * 获取并展示登录的QQ的部分信息并在配置中记录此信息
     * @param configuration
     */
    private void getAndShowQQInfo(HttpConfiguration configuration){
        //获取登录的机器人的信息
        LoginQQInfo loginQQInfo = httpSender.getLoginQQInfo();
        configuration.setLoginQQInfo(loginQQInfo);


        QQLog.info(Colors.builder().add("QQ    : "+loginQQInfo.getQQ(), Colors.FONT.YELLOW).build());
        QQLog.info(Colors.builder().add("NICK  : "+loginQQInfo.getName(), Colors.FONT.YELLOW).build());
        QQLog.info(Colors.builder().add("LEVEL : "+loginQQInfo.getLevel(), Colors.FONT.YELLOW).build());

    }

    /**
     * 开发者实现的获取Config对象的方法,对象请保证每次获取的时候都是唯一的
     */
    @Override
    protected HttpConfiguration getConfiguration() {
        return HttpApiResourceDispatchCenter.getHttpConfiguration();
    }

    /**
     * close 实现方法
     */
    @Override
    public void close() {
        httpServer.close();
    }

    //**************** 构造 ****************//


    /**
     * 无参构造
     */
    public HttpApplication() {
    }

    /**
     * 日志拦截构造
     */
    public HttpApplication(QQLogBack qqLogBack) {
        super(qqLogBack);
    }
}
