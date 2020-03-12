package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.GroupAddRequest;
import com.forte.qqrobot.beans.messages.types.GroupAddRequestType;

/**
 * 群添加请求
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_groupAddRequest extends BaseMsgGet implements GroupAddRequest {
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
     * 加群类型
     */
    @Override
    public GroupAddRequestType getRequestType() {
        //事件子类型，1/他人申请入群，2/自己(即登录号)受邀入群
        return getSubType() == 1 ? GroupAddRequestType.ADD : getSubType() == 2 ? GroupAddRequestType.INVITE : null;
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
