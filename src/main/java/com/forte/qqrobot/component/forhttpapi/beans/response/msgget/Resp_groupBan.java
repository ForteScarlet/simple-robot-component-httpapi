package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.GroupBan;
import com.forte.qqrobot.beans.messages.types.GroupBanType;

/**
 * 群禁言，但是似乎不会更新了。姑且写一下
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_groupBan extends BaseMsgGet implements GroupBan {

    /*
        {
            "type":104,
            "subType":1,
            "time":1583338918,
            "loginQQ":12345,
            "qq":23456,
            "group":34567,
            "beingOperateQQ":45678,
            "duration":0
        }
     */
    private String qq;
    private String group;
    private String beingOperateQQ;
    private Long duration = 0L;


    @Override
    public GroupBanType getBanType() {
        if(getDuration() == 0){
            return GroupBanType.LIFT_BAN;
        }else{
            return GroupBanType.BAN;
        }
    }

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public String getOperatorQQ() {
        return getQq();
    }

    @Override
    public String getBeOperatedQQ() {
        return getBeingOperateQQ();
    }

    @Override
    public Long time() {
        return getTime();
    }

    @Override
    public String getId() {
        return getQq() + getBeingOperateQQ() + getTime() + getDuration();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getBeingOperateQQ() {
        return beingOperateQQ;
    }

    public void setBeingOperateQQ(String beingOperateQQ) {
        this.beingOperateQQ = beingOperateQQ;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
