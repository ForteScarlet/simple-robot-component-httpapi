package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.FriendAdd;

import java.time.Instant;

/**
 * 好友已添加事件
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_friendAdd implements FriendAdd {

    /*
    {
        "type":201,
        "subType":1,
        "qq":11223456
    }
     */
    private Integer type;
    private Integer subType;
    /** 原始数据 */
    private String originalData;
    /** 没有时间参数，通过程序获取 */
    private Long time = Instant.now().getEpochSecond();

    /** 好友的qq号 */
    private String qq;



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

    /**
     * 获取ID，如果没有此参数推荐使用UUID等来代替
     */
    @Override
    public String getId() {
        return type + "_" + subType;
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

    /**
     * 添加人的QQ
     */
    @Override
    public String getQQ() {
        return qq;
    }
}
