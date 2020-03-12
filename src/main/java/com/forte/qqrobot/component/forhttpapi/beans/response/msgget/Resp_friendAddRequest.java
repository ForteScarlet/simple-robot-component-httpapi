package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.AbstractFriendAddRequest;
import com.forte.qqrobot.beans.messages.msgget.FriendAddRequest;

import java.time.Instant;

/**
 * 好友添加请求
 *
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_friendAddRequest extends BaseMsgGet implements FriendAddRequest {
    /*
        {
            "type":301,
            "subType":1,
            "qq":11223456,
            "msg":"问题1:加我作甚么 回答:。。。",
            "responseFlag":"2479"
        }
     */

    private String qq;
    private String msg;
    private String responseFlag;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 请求人QQ
     */
    @Override
    public String getQQ() {
        return qq;
    }

    /**
     * 获取ID，如果没有此参数推荐使用UUID等来代替
     */
    @Override
    public String getId() {
        return getFlag();
    }

    @Override
    public String getMsg() {
        return msg;
    }

    /**
     * 请求的时候应该有标识一类的东西
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
