package com.forte.qqrobot.component.forhttpapi;

import com.forte.qqrobot.component.forhttpapi.http.HttpSender;
import com.forte.qqrobot.component.forhttpapi.http.QQHttpMsgSender;
import com.forte.qqrobot.component.forhttpapi.http.QQHttpServer;

/**
 *
 * HTTP API 组件可以提供的特殊API
 *
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class HttpApiSpecialApi {

    private final HttpSender sender;

    private final QQHttpServer server;

    /**
     * 构造
     */
    HttpApiSpecialApi(HttpSender sender, QQHttpServer httpServer){
        this.sender = sender;
        this.server = httpServer;
    }


    public QQHttpServer getServer() {
        return server;
    }

    /**
     * 获取Sender
     */
    public HttpSender getSender() {
        return sender;
    }
}
