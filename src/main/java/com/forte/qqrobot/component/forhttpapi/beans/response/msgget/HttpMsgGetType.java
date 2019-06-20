package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.*;

/**
 * 所有接收的消息的类型封装类
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public enum HttpMsgGetType {


    /** 私信信息 */
    privateMsg(1, Resp_privateMsg.class),

    /** 讨论组信息 */
    discussMsg(4, Resp_discussMsg.class),

    /** 群消息 */
    groupMsg(2, Resp_groupMsg.class),

    /** 事件-群文件上传 */
    groupFileUpload(11, Resp_groupUpload.class),

    /** 事件-好友添加 */
    friendAdd(201, Resp_friendAdd.class),

    /** 事件-管理员变动 */
    groupAdminChange(101, Resp_groupAdminChange.class),

    /** 事件-群成员增加 */
    groupMemberIncrease(103, Resp_groupMemberIncrease.class),

    /** 事件-群成员减少 */
    groupMemberReduce(102, Resp_groupMemberDecrease.class),

    /** 请求-添加好友 */
    friendAddRequest(301, Resp_friendAddRequest.class),

    /** 请求-群添加 */
    groupAddRequest(302, Resp_groupAddRequest.class),
    ;

    private final Integer bigType;
    private final Class<? extends MsgGet> types;

    /** 构造 */
    HttpMsgGetType(Integer bigType, Class<? extends MsgGet> types){
        this.bigType = bigType;
        this.types = types;
    }

    public Integer getBigType(){
        return bigType;
    }

    public Class<? extends MsgGet> getType(){
        return types;
    }

    /**
     * 根据大类型获取对应类型枚举
     */
    public HttpMsgGetType getByType(int type){
        for (HttpMsgGetType value : values()) {
            if(value.bigType == type){
                return value;
            }
        }
        return null;
    }

}
