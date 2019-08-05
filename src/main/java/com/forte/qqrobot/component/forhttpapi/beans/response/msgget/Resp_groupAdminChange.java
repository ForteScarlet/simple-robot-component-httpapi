package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.AbstractGroupAdminChange;
import com.forte.qqrobot.beans.messages.types.GroupAdminChangeType;

import java.time.Instant;

/**
 * 群管理员变动事件
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_groupAdminChange extends AbstractGroupAdminChange {

    private Integer type;
    private Integer subType;
    /** 原始数据 */
    private String originalData;
    /** 没有时间参数，通过程序获取 */
    private Long time = Instant.now().getEpochSecond();

    /*
        {
        "type":101,
        "subType":1,
        "group":123456,
        "beingOperateQQ":123456
    }
     */
    /** 群号 */
    private String group;
    /** 操作者的qq */
    private String qq;
    /** 变动者的qq号 */
    private String beingOperateQQ;


    /**
     * 获取类型
     */
    @Override
    public GroupAdminChangeType getType() {
        /* 子类型， 1/被取消管理员，2/被设置管理员 */
        if(subType == 1){
            return GroupAdminChangeType.CANCEL_ADMIN;
        }

        if(subType == 2){
            return GroupAdminChangeType.BECOME_ADMIN;
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
    public long getTime() {
        return time;
    }

    @Override
    public void setTime(Long time) {
        this.time = time;
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

    @Override
    public String getQq() {
        return qq;
    }

    @Override
    public void setQq(String qq) {
        this.qq = qq;
    }
}
