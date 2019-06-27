package com.forte.qqrobot.component.forhttpapi;

import com.forte.plusutils.consoleplus.console.Colors;
import com.forte.qqrobot.BaseApplication;
import com.forte.qqrobot.beans.messages.result.LoginQQInfo;
import com.forte.qqrobot.component.forhttpapi.http.*;
import com.forte.qqrobot.listener.invoker.ListenerManager;
import com.forte.qqrobot.log.QQLog;
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
public class HttpApplication extends BaseApplication<HttpConfiguration> {

    /** 送信器 */
    protected HttpSender httpSender;

    /** http 服务器 */
    private QQHttpServer httpServer;

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
     * 开发者实现的启动方法
     *
     * @param manager 监听管理器，用于分配获取到的消息
     */
    @Override
    protected String start(ListenerManager manager) {
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
        String encode = HttpConfiguration.getEncode();
        String[] method = configuration.getMethod();

        long s = System.currentTimeMillis();

        try {
            this.httpServer = QQHttpServer.start(port, listenerPath, backlog, encode, method, manager, httpSender);
        } catch (IOException e) {
            throw new RuntimeException("服务端构建失败", e);
        }

        QQLog.debug("尝试获取登录QQ信息...");
        getAndShowQQInfo(configuration);
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
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     *
     * <p> As noted in {@link AutoCloseable#close()}, cases where the
     * close may fail require careful attention. It is strongly advised
     * to relinquish the underlying resources and to internally
     * <em>mark</em> the {@code Closeable} as closed, prior to throwing
     * the {@code IOException}.
     *
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        httpServer.close();
    }
}
