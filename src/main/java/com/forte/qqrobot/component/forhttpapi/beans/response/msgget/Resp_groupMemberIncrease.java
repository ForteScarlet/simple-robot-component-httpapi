package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.AbstractGroupMemberIncrease;
import com.forte.qqrobot.beans.messages.msgget.GroupMemberIncrease;
import com.forte.qqrobot.beans.messages.types.IncreaseType;

import java.time.Instant;

/**
 * 群成员增加事件
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_groupMemberIncrease extends BaseMsgGet implements GroupMemberIncrease {
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
        if(getSubType() == 1){
            return IncreaseType.AGREE;
        }
        if(getSubType() == 2){
            return IncreaseType.INVITE;
        }

        return null;
    }

    /**
     * 获取ID，如果没有此参数推荐使用UUID等来代替
     */
    @Override
    public String getId() {
        return getBigType()+"_"+getSubType();
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
