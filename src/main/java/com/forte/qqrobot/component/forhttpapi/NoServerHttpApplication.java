package com.forte.qqrobot.component.forhttpapi;

import com.forte.plusutils.consoleplus.console.Colors;
import com.forte.qqrobot.BaseApplication;
import com.forte.qqrobot.BaseConfiguration;
import com.forte.qqrobot.beans.messages.msgget.MsgGet;
import com.forte.qqrobot.beans.messages.result.LoginQQInfo;
import com.forte.qqrobot.component.forhttpapi.http.HttpSender;
import com.forte.qqrobot.component.forhttpapi.http.QQHttpMsgSender;
import com.forte.qqrobot.component.forhttpapi.http.QQJSONMsgCreator;
import com.forte.qqrobot.component.forhttpapi.utils.ListenBeansUtil;
import com.forte.qqrobot.exception.RobotRuntimeException;
import com.forte.qqrobot.listener.invoker.ListenerManager;
import com.forte.qqrobot.log.QQLog;
import com.forte.qqrobot.log.QQLogBack;
import com.forte.qqrobot.sender.senderlist.SenderGetList;
import com.forte.qqrobot.sender.senderlist.SenderList;
import com.forte.qqrobot.sender.senderlist.SenderSendList;
import com.forte.qqrobot.sender.senderlist.SenderSetList;

import java.util.function.Consumer;


/**
 * 不启动内置服务器的启动器，通过方法返回一个字符串接收函数
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class NoServerHttpApplication extends BaseApplication<NoServerHttpConfiguration, HttpSender> {

    /**
     * json参数接收函数
     */
    private Consumer<String> jsonGet;

    /** 送信器 */
    private HttpSender httpSender;

    /**
     * 开发者实现的资源初始化
     */
    @Override
    protected void resourceInit(NoServerHttpConfiguration configuration) {

    }

    /**
     * 开发者实现的资源初始化
     */
    @Override
    protected void resourceInit() {
        HttpApiResourceDispatchCenter.saveHttpConfiguration(new NoServerHttpConfiguration());
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

    @Override
    public HttpSender getSpecialApi() {
        return httpSender;
    }

    /**
     * 仅重写此部分，移除掉服务启动
     * @param manager 监听管理器，用于分配获取到的消息
     */
    @Override
    protected String start(ListenerManager manager){
        String msg = "无内置server启动。";
        QQLog.info(Colors.builder().add(msg, Colors.FONT.DARK_GREEN).build());
        NoServerHttpConfiguration configuration = getConfiguration();
        QQLog.debug("尝试获取登录QQ信息...");
        getAndShowQQInfo(configuration);

        //初始化json参数获取函数
        jsonGet = buildJsonGetFunction(manager, this.httpSender);
        return "No Server";
    }

    /**
     * 开发者实现的获取Config对象的方法,对象请保证每次获取的时候都是唯一的
     */
    @Override
    protected NoServerHttpConfiguration getConfiguration() {
        //如果是无服务器启动器，则此配置可以强转为无服务器配置类
        return (NoServerHttpConfiguration) HttpApiResourceDispatchCenter.getHttpConfiguration();
    }

    /**
     * 获取并展示登录的QQ的部分信息并在配置中记录此信息
     * @param configuration
     */
    private void getAndShowQQInfo(BaseConfiguration configuration){
        //获取登录的机器人的信息
        LoginQQInfo loginQQInfo = httpSender.getLoginQQInfo();
        configuration.setLoginQQInfo(loginQQInfo);

        QQLog.info(Colors.builder().add("QQ    : " + loginQQInfo.getQQ(), Colors.FONT.YELLOW).build());
        QQLog.info(Colors.builder().add("NICK  : " + loginQQInfo.getName(), Colors.FONT.YELLOW).build());
        QQLog.info(Colors.builder().add("LEVEL : " + loginQQInfo.getLevel(), Colors.FONT.YELLOW).build());
    }

    /**
     * 构建参数获取函数
     * 参数类型应为json字符串
     */
    private Consumer<String> buildJsonGetFunction(ListenerManager manager, SenderList senderList){
        return str -> {
            //转化为MsgGet对象
            MsgGet msgGet = ListenBeansUtil.jsonToMsgGet(str);
            if(msgGet != null){
                manager.onMsg(msgGet, senderList);
            }
        };
    }

    /**
     * 获取消息接收函数
     * 此函数接收HTTP API插件的原始json字符串并进行解析
     */
    public Consumer<String> jsonGetFunction(){
        if(this.jsonGet == null){
            throw new RobotRuntimeException("您尚未启动服务或者启动服务过程中出现异常。");
        }
        return this.jsonGet;
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
     */
    @Override
    public void close() {
    }

    //**************** 构造 ****************//


    /**
     * 无参构造
     */
    public NoServerHttpApplication() {
    }

    /**
     * 日志拦截构造
     */
    public NoServerHttpApplication(QQLogBack qqLogBack) {
        super(qqLogBack);
    }
}
