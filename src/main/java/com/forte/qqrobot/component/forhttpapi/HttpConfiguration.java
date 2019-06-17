package com.forte.qqrobot.component.forhttpapi;

import com.forte.qqrobot.BaseConfiguration;

/**
 * HTTP API连接使用的配置类
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/4/4 18:17
 * @since JDK1.8
 **/
public class HttpConfiguration extends BaseConfiguration {


    /**
     * 服务器ip，默认为127.0.0.1
     */
    private String ip = "127.0.0.1";

    /**
     * 服务器请求地址，默认为/coolq
     */
    private String serverPath = "/coolq";

    /**
     * 服务器端口地址，默认为15514
     */
    private int port = 15514;

    /**
     * 接收的请求方式，默认为 post
     */
    private String[] method = {"post"};

    public String getHttpRequestUrl(){
        //服务器IP+端口+请求路径
        return getIp() + ":" + getPort() + getServerPath();
    }

    /* —————————————— getter && setter ———————————— */

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String[] getMethod() {
        return method;
    }

    public void setMethod(String[] method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
