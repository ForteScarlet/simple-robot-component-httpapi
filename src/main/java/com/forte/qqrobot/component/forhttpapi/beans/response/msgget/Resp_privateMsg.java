package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.AbstractPrivateMsg;
import com.forte.qqrobot.beans.messages.msgget.PrivateMsg;
import com.forte.qqrobot.beans.messages.types.PrivateMsgType;
import com.forte.qqrobot.component.forhttpapi.beans.response.Resp_getStrangerInfo;

import java.time.Instant;

/**
 * 私信消息
 *
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_privateMsg extends BaseMsgGet implements PrivateMsg, Imageable, Anonable {
    /*
        "type":2,
        "subType":1,
        "qq":123456,
        "group":667890,
        "msg":"gg",
        "font":182084192,
        "msgID":999
     */
    /**
     * qq号
     */
    private String qq;
    /**
     * 群号
     */
    private String group;
    /**
     * 消息正文
     */
    private String msg;
    /**
     * 字体
     */
    private String font;
    /**
     * 消息ID
     */
    private String msgID;

    /**
     * 图片消息原文
     */
    private String originalMsg;

    /**
     * 图片消息封装类
     */
    private MsgImage[] imageInfo;

    /*
        可能存在匿名消息
        "fromAnonymous":"AAAAA0Q194=",
        "anonymousInfo":{
            "aid":1000013,
            "code":"曹植",
            "token":"S4EyN0c8/DX3g=="
        }
     */
    /**
     * 匿名标识
     */
    private String fromAnonymous;

    /**
     * 匿名消息封装类
     */
    private AnonMsg anonymousInfo;

    /**
     * 获取后通过qq号来反向获取到陌生人信息
      */
    private Resp_getStrangerInfo strangerInfo;


    @Override
    public PrivateMsgType getType() {
        /* 事件子类型，11/来自好友，1/普通消息，2/匿名消息，3/系统消息 */
        //如果存在群号，则是群消息
        if (group != null && group.trim().length() > 0) {
            return PrivateMsgType.FROM_GROUP;
        }

        //不区分讨论组、好友、在线之类的，则普通消息、匿名消息认为是好友消息
        Integer subType = getSubType();
        if (subType == 11 || subType == 1 || subType == 2) {
            return PrivateMsgType.FROM_FRIEND;
        }

        //为3，系统消息
        if (subType == 3) {
            return PrivateMsgType.FROM_SYSTEM;
        }

        //如果都没判断出来，则返回null
        return null;
    }

    /**
     * 获取发送人的QQ号
     */
    @Override
    public String getQQ() {
        return qq;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 获取ID，如果没有此参数推荐使用UUID等来代替
     */
    @Override
    public String getId() {
        return msgID;
    }

    @Override
    public String getMsg() {
        return msg;
    }

//    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getMsgID() {
        return msgID;
    }

    public void setMsgID(String msgID) {
        this.msgID = msgID;
    }

    public void setOriginalMsg(String originalMsg) {
        this.originalMsg = originalMsg;
    }

    /**
     * 获取图片信息封装类数组
     * @return
     */
    @Override
    public MsgImage[] getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(MsgImage[] imageInfo) {
        this.imageInfo = imageInfo;
    }


    /**
     * 图片消息原文
     */
    @Override
    public String getOriginalMsg() {
        return originalMsg;
    }

    @Override
    public String getFromAnonymous() {
        return fromAnonymous;
    }

    public void setFromAnonymous(String fromAnonymous) {
        this.fromAnonymous = fromAnonymous;
    }

    @Override
    public AnonMsg getAnonymousInfo() {
        return anonymousInfo;
    }

    public void setAnonymousInfo(AnonMsg anonymousInfo) {
        this.anonymousInfo = anonymousInfo;
    }

}
