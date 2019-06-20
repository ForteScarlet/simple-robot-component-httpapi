package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

/**
 * 消息获取类的统一接口，规定一些通用方法
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public interface MsgBean {

    /** 获取主类型,由于核心框架中已经存在此方法，更名*/
//    String getType();
    Integer getBigType();

    /** 获取子类型 */
    Integer getSubType();

    /** 获取消息 */
    String getMsg();

}
