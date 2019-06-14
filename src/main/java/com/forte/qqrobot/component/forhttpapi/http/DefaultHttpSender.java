package com.forte.qqrobot.component.forhttpapi.http;


import com.forte.qqrobot.component.forhttpapi.beans.response.RespBean;

import java.util.Optional;

/**
 *
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/30 11:16
 * @since JDK1.8
 **/
public class DefaultHttpSender {

//    /**
//     * 私有构造
//     * @param creator
//     */
//    DefaultHttpSender(QQJSONMsgCreator creator) {
//        super(creator);
//    }
//
//    /**
//     * 构造
//     */
//    public DefaultHttpSender(){
//        super(SocketResourceDispatchCenter.getQQJSONMsgCreator());
//    }

    /**
     * 通过HTTP API插件获取所需消息
     * * 重写后，使其失去作用而只会返回null值
     * @param json     json参数字符串
     * @param beanType bean类型
     */
    public <T extends RespBean> Optional<T> get(String json, Class<T> beanType) {
        return Optional.empty();
    }
}
