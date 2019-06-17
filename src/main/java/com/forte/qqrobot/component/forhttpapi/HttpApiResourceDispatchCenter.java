package com.forte.qqrobot.component.forhttpapi;

import com.forte.qqrobot.ResourceDispatchCenter;
import com.forte.qqrobot.component.forhttpapi.http.HttpSender;
import com.forte.qqrobot.component.forhttpapi.http.QQHttpMsgSender;
import com.forte.qqrobot.component.forhttpapi.http.QQJSONMsgCreator;
import com.forte.qqrobot.utils.SingleFactory;

/**
 * HTTP API使用的资源调度器
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/4/15 17:15
 * @since JDK1.8
 **/
public class HttpApiResourceDispatchCenter extends ResourceDispatchCenter {

    /**
     * 保存一个Http配置类
     * @param httpConfiguration Http配置类
     */
    static void saveHttpConfiguration(HttpConfiguration httpConfiguration){
        saveConfiguration(httpConfiguration);
    }

    /**
     * 保存一个QQJSONMsg生成器
     * @param qqjsonMsgCreator QQJSONMsg生成器
     */
    static void saveQQJSONMsgCreator(QQJSONMsgCreator qqjsonMsgCreator){
        save(qqjsonMsgCreator);
    }

    /**
     * 保存一个QQHttpMsgSender(真实送信器)
     * @param qqHttpMsgSender QQHttpMsgSender(真正的送信器)
     */
    static void saveQQHttpMsgSender(QQHttpMsgSender qqHttpMsgSender){
        save(qqHttpMsgSender);
    }

    /**
     * 保存一个HttpSender(送信器接口实现者)
     * @param httpSender 送信器接口实现者
     */
    static void saveHttpSender(HttpSender httpSender){
        save(httpSender);
    }

    //**************** get ****************//


    /**
     * 获取一个HttpConfiguration单例对象
     * @return HttpConfiguration单例对象
     */
    public static HttpConfiguration getHttpConfiguration(){
        return get(HttpConfiguration.class);
    }

    /**
     * 获取一个QQJSONMsgCreator单例对象
     * @return QQJSONMsgCreator单例对象
     */
    public static QQJSONMsgCreator getQQJSONMsgCreator(){
        return get(QQJSONMsgCreator.class);
    }

    /**
     * 获取一个QQHttpMsgSender单例对象
     * @return QQHttpMsgSender单例对象
     */
    public static QQHttpMsgSender getQQHttpMsgSender(){
        return get(QQHttpMsgSender.class);
    }

    /**
     * 获取一个HttpSender单例对象
     * @return HttpSender单例对象
     */
    public static HttpSender httpSender(){
        return get(HttpSender.class);
    }

}
