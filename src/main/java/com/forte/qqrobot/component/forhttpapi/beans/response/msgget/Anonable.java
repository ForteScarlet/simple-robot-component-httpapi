package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

/**
 * 有些消息接口可能会存在匿名消息
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public interface Anonable {

        String getFromAnonymous();

        AnonMsg getAnonymousInfo();
}
