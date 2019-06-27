package com.forte.qqrobot.component.forhttpapi;

import com.forte.qqrobot.BaseConfiguration;

/**
 * 没有服务器的配置，移除了对内置服务器的配置
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class NoServerHttpConfiguration extends HttpConfiguration {

    /** 服务器端口 */
    private int serverPort = 8877;

    @Override
    public int getServerPort() {
        return serverPort;
    }

    @Override
    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    @Override
    @Deprecated
    public String getHttpRequestUrl() {
        return super.getHttpRequestUrl();
    }

    @Override
    @Deprecated
    public String getServerPath() {
        return super.getServerPath();
    }

    /**
     * 配置java服务器的请求路径，默认为/coolq
     * @deprecated 无服务器配置不生效
     */
    @Override
    @Deprecated
    public void setServerPath(String serverPath) {
        super.setServerPath(serverPath);
    }

    @Override
    @Deprecated
    public int getJavaPort() {
        return super.getJavaPort();
    }

    /**
     * 配置java服务器的监听端口，默认为15514
     * @deprecated 无服务器配置不生效
     */
    @Override
    @Deprecated
    public void setJavaPort(int javaPort) {
        super.setJavaPort(javaPort);
    }

    @Override
    @Deprecated
    public String[] getMethod() {
        return super.getMethod();
    }

    /**
     * 配置java服务器可接收的请求类型，默认为post类型
     * @deprecated 无服务器配置不生效
     * @param method
     */
    @Override
    @Deprecated
    public void setMethod(String[] method) {
        super.setMethod(method);
    }

    @Override
    @Deprecated
    public int getBacklog() {
        return super.getBacklog();
    }

    /**
     * TCP连接最大并发数, 传 0 或负数表示使用默认值，默认为0
     * @deprecated 无服务器配置不生效
     * @param backlog
     */
    @Override
    @Deprecated
    public void setBacklog(int backlog) {
        super.setBacklog(backlog);
    }
}
