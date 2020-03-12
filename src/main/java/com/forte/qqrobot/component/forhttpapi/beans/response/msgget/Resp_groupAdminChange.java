package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.GroupAdminChange;
import com.forte.qqrobot.beans.messages.types.GroupAdminChangeType;

/**
 * 群管理员变动事件
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_groupAdminChange extends BaseMsgGet implements GroupAdminChange {
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
        if(getSubType() == 1){
            return GroupAdminChangeType.CANCEL_ADMIN;
        }

        if(getSubType() == 2){
            return GroupAdminChangeType.BECOME_ADMIN;
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
