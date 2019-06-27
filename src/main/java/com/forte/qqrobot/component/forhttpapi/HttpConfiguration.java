package com.forte.qqrobot.component.forhttpapi;

import com.forte.qqrobot.BaseConfiguration;
import com.forte.qqrobot.sender.MsgSender;

/**
 * HTTP API连接使用的配置类
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/4/4 18:17
 * @since JDK1.8
 **/
public class HttpConfiguration extends BaseConfiguration {


    /** 服务器端口 */
    private int serverPort = 8877;

    /**
     * 服务器请求地址，默认为/coolq
     */
    private String serverPath = "/coolq";

    /**
     * java监听端口地址，默认为15514
     */
    private int javaPort = 15514;

    /** TCP连接最大并发数, 传 0 或负数表示使用默认值 */
    private int backlog = 0;

    /**
     * 接收的请求方式，默认为 post
     */
    private String[] method = {"post"};



    public String getHttpRequestUrl(){
        //服务器IP+端口+请求路径
        return "http://"+getIp() + ":" + getServerPort(); /*+ getServerPath();*/
    }

    /* —————————————— getter && setter ———————————— */

    public String getServerPath() {
        return serverPath;
    }

    /** 配置java服务器的请求路径，默认为/coolq */
    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public int getJavaPort() {
        return javaPort;
    }

    /** 配置java服务器的监听端口，默认为15514 */
    public void setJavaPort(int javaPort) {
        this.javaPort = javaPort;
    }

    public String[] getMethod() {
        return method;
    }
    /** 配置java服务器可接收的请求类型，默认为post类型 */
    public void setMethod(String[] method) {
        this.method = method;
    }


    public int getBacklog() {
        return backlog;
    }

    /** TCP连接最大并发数, 传 0 或负数表示使用默认值，默认为0 */
    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }

    public int getServerPort() {
        return serverPort;
    }

    /** 配置酷Q端的端口地址，默认为8877 */
    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }



}
