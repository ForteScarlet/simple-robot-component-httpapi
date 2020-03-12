package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.GroupMemberReduce;
import com.forte.qqrobot.beans.messages.types.ReduceType;

/**
 * 群成员减少
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_groupMemberDecrease extends BaseMsgGet implements GroupMemberReduce {
    /*
        {
            "type":102,
            "subType":2,
            "qq":99998,
            "group":123456,
            "beingOperateQQ":11223456
        }
     */

    private String qq;
    private String group;
    private String beingOperateQQ;


    @Override
    public ReduceType getType() {
        /* 1/群员离开，2/群员被踢 */

        if(getSubType() == 1){
            return ReduceType.LEAVE;
        }
        if(getSubType() == 2){
            return ReduceType.KICK_OUT;
        }

        return null;
    }

    /**
     * 获取ID，如果没有此参数推荐使用UUID等来代替
     */
    @Override
    public String getId() {
        return getBigType() + "_" + getSubType();
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
