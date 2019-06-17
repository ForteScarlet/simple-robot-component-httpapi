package com.forte.qqrobot.component.forhttpapi.http;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.function.Function;

/**
 * 应用于HTTP API交互的server服务器端
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/30 10:54
 * @since JDK1.8
 **/
public class QQHttpServer implements Closeable {

    private final HttpServer httpserver;

    /**
     * 构造
     */
    private QQHttpServer(HttpServer httpserver){
        this.httpserver = httpserver;
    }

    /**
     * 开启服务
     * @param port 端口号
     * @param listenerPath 监听地址
     * @param  backlog TCP连接最大并发数, 传 0 或负数表示使用默认值
      */
    public static QQHttpServer start(int port, String listenerPath, int backlog, String encode, Function<String, Resp> msgConsumer, String[] methods) throws IOException {
            HttpServerProvider provider = HttpServerProvider.provider();
            HttpServer httpserver = provider.createHttpServer(new InetSocketAddress(port), backlog);
            //注册监听地址
            httpserver.createContext(listenerPath, new QQHttpHandler(encode, msgConsumer, methods));
            //启动服务
            httpserver.start();
            return new QQHttpServer(httpserver);
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
