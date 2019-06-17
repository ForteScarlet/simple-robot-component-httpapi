package com.forte.qqrobot.component.forhttpapi;

import com.forte.qqrobot.BaseApplication;
import com.forte.qqrobot.component.forhttpapi.http.HttpSender;
import com.forte.qqrobot.component.forhttpapi.http.QQHttpMsgSender;
import com.forte.qqrobot.component.forhttpapi.http.QQHttpServer;
import com.forte.qqrobot.component.forhttpapi.http.QQJSONMsgCreator;
import com.forte.qqrobot.listener.invoker.ListenerManager;
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
    private HttpSender httpSender;

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
    protected void start(ListenerManager manager) {
        // TODO 启动服务

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
    }
}
