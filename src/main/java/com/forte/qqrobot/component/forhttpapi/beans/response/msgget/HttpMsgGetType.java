package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.*;

import java.util.*;

/**
 * 所有接收的消息的类型封装类
 * 伪枚举类
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class HttpMsgGetType {


    /** 私信信息 */
    public static final HttpMsgGetType privateMsg = register("privateMsg", 1, Resp_privateMsg.class);

    /** 讨论组信息 */
    public static final HttpMsgGetType discussMsg = register("discussMsg", 4, Resp_discussMsg.class);

    /** 群消息 */
    public static final HttpMsgGetType groupMsg = register("groupMsg", 2, Resp_groupMsg.class);

    /** 事件-群文件上传 */
    public static final HttpMsgGetType groupFileUpload = register("groupFileUpload", 11, Resp_groupUpload.class);

    /** 事件-好友添加 */
    public static final HttpMsgGetType friendAdd = register("friendAdd", 201, Resp_friendAdd.class);

    /** 事件-管理员变动 */
    public static final HttpMsgGetType groupAdminChange = register("groupAdminChange", 101, Resp_groupAdminChange.class);

    /** 事件-群成员增加 */
    public static final HttpMsgGetType groupMemberIncrease = register("groupMemberIncrease", 103, Resp_groupMemberIncrease.class);

    /** 事件-群成员减少 */
    public static final HttpMsgGetType groupMemberReduce = register("groupMemberReduce", 102, Resp_groupMemberDecrease.class);

    /** 请求-添加好友 */
    public static final HttpMsgGetType friendAddRequest = register("friendAddRequest", 301, Resp_friendAddRequest.class);

    /** 请求-群添加 */
    public static final HttpMsgGetType groupAddRequest = register("groupAddRequest", 302, Resp_groupAddRequest.class);

    /** 群禁言事件 */
    public static final HttpMsgGetType groupBan = register("groupBan", 104, Resp_groupBan.class);
    ;

    private final String name;
    private final Integer bigType;
    private final Class<? extends MsgGet> types;
    private static Map<String, HttpMsgGetType> ALL_TYPES;

    /** 构造 */
    private HttpMsgGetType(String name, Integer bigType, Class<? extends MsgGet> types){
        this.name = name;
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
     * 注册一个新的HTTP监听消息类型
     * @param bigType 大类型id
     * @param types   对应的封装类
     * @return 类型对象
     */
    public static HttpMsgGetType register(String name, int bigType, Class<? extends MsgGet> types){
        Objects.requireNonNull(name);
        Objects.requireNonNull(types);

        HttpMsgGetType httpMsgGetType = new HttpMsgGetType(name, bigType, types);
        if(ALL_TYPES == null){
            ALL_TYPES = new HashMap<>(2);
        }
        return ALL_TYPES.merge(name, httpMsgGetType, (old, val) -> {
            throw new IllegalArgumentException(name + " has already exists.");
        });
    }


    public static HttpMsgGetType[] values(){
        return ALL_TYPES.values().toArray(new HttpMsgGetType[0]);
    }

    public static HttpMsgGetType valueOf(String name){
        return ALL_TYPES.get(name);
    }

    /**
     * 根据大类型获取对应类型枚举
     */
    public static HttpMsgGetType getByType(int type){
        Collection<HttpMsgGetType> values = ALL_TYPES.values();
        for (HttpMsgGetType value : values) {
            if(value.bigType == type){
                return value;
            }
        }
        return null;
    }

}
