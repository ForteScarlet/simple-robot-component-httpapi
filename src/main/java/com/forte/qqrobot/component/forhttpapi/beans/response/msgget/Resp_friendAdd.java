package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.AbstractFriendAdd;

import java.time.Instant;

/**
 * 好友已添加事件
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_friendAdd extends AbstractFriendAdd {
    /*
    {
        "type":201,
        "subType":1,
        "qq":11223456
    }
     */

    /** 好友的qq号 */
    private String qq;


    @Override
    public String getQq() {
        return qq;
    }

    @Override
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
