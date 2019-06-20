package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

/**
 * 使用在接收消息中，代表此消息可能存在图片内容。
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public interface Imageable {

    /** 图片消息原文 */
    String getOriginalMsg();

    /** 获取图片信息封装类数组 */
    MsgImage[] getImageInfo();

}
