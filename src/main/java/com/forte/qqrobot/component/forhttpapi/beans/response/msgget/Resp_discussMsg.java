package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.AbstractDiscussMsg;
import com.forte.qqrobot.beans.messages.msgget.DiscussMsg;

import java.time.Instant;

/**
 * 讨论组消息
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_discussMsg extends BaseMsgGet implements DiscussMsg, Imageable, Anonable {
    /*
        {
            "type":4,
            "subType":1,
            "qq":6767688,
            "group":123456,
            "msg":"gg",
            "font":44199040,
            "msgID":999
        }
     */

    /** qq号 */
    private String qq;
    /** 群号 */
    private String group;
    /** 消息正文 */
    private String msg;
    /** 所用字体 */
    private String font;
    /** 消息ID */
    private String msgID;

    /** 图片消息字符串 */
    private String originalMsg;
    /** 图片消息 */
    private MsgImage[] imageInfo;
    /** 匿名标识 */
    private String fromAnonymous;
    /** 匿名消息 */
    private AnonMsg anonymousInfo;


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
     * 获取发消息的人的QQ
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

    @Override
    public String getOriginalMsg() {
        return originalMsg;
    }

    public void setOriginalMsg(String originalMsg) {
        this.originalMsg = originalMsg;
    }

    @Override
    public MsgImage[] getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(MsgImage[] imageInfo) {
        this.imageInfo = imageInfo;
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
