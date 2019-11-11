package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.AbstractGroupMemberIncrease;
import com.forte.qqrobot.beans.messages.types.IncreaseType;

import java.time.Instant;

/**
 * 群成员增加事件
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_groupMemberIncrease extends AbstractGroupMemberIncrease {

    private Integer type;
    private Integer subType;
    /** 原始数据 */
    private String originalData;
    /** 没有时间参数，通过程序获取 */
    private Long time = Instant.now().getEpochSecond();

    /*
        {
            "type":103,
            "subType":1,
            "qq":666663,
            "group":123456,
            "beingOperateQQ":11223456
        }
     */
    /** 操作者qq */
    private String qq;
    /** 群号 */
    private String group;
    /** 加进来的人的qq号 */
    private String beingOperateQQ;




    @Override
    public IncreaseType getType() {
        /* 1/管理员已同意，2/管理员邀请 */
        if(subType == 1){
            return IncreaseType.AGREE;
        }
        if(subType == 2){
            return IncreaseType.INVITE;
        }

        return null;
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

    @Override
    public void setOriginalData(String originalData) {
        this.originalData = originalData;
    }

    /**
     * 获取ID，如果没有此参数推荐使用UUID等来代替
     */
    @Override
    public String getId() {
        return type+"_"+subType;
    }

    @Override
    public Long getTime() {
        return time;
    }

    @Override
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
     * 操作者的QQ号
     */
    @Override
    public String getOperatorQQ() {
        return qq;
    }

    /**
     * 被操作者的QQ号
     */
    @Override
    public String getBeOperatedQQ() {
        return beingOperateQQ;
    }

    @Override
    public void setGroup(String group) {
        this.group = group;
    }

    public String getBeingOperateQQ() {
        return beingOperateQQ;
    }

    public void setBeingOperateQQ(String beingOperateQQ) {
        this.beingOperateQQ = beingOperateQQ;
    }
}
