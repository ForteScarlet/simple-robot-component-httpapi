package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.GroupAddRequest;

import java.time.Instant;

/**
 * 群添加请求
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_groupAddRequest implements GroupAddRequest {

    private Integer type;
    private Integer subType;
    /**
     * 原始数据
     */
    private String originalData;
    /**
     * 没有时间参数，通过程序获取
     */
    private Long time = Instant.now().getEpochSecond();

    /*
    {
        "type":302,
        "subType":1,
        "qq":23333333,
        "group":123456,
        "msg":"",
        "responseFlag":"2477"
    }
     */
    /** qq号 */
    private String qq;
    /** 群号 */
    private String group;
    /** 消息 */
    private String msg;
    /** 标识 */
    private String responseFlag;



    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    @Override
    public String getOriginalData() {
        return originalData;
    }

    public void setOriginalData(String originalData) {
        this.originalData = originalData;
    }

    @Override
    public long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String getGroup() {
        return group;
    }

    /**
     * 获取QQ号
     */
    @Override
    public String getQQ() {
        return qq;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 获取ID，如果没有此参数推荐使用UUID等来代替
     */
    @Override
    public String getId() {
        return responseFlag;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    /**
     * 请求类消息的标识
     */
    @Override
    public String getFlag() {
        return responseFlag;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResponseFlag() {
        return responseFlag;
    }

    public void setResponseFlag(String responseFlag) {
        this.responseFlag = responseFlag;
    }
}
