package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.AbstractGroupMsg;
import com.forte.qqrobot.beans.messages.msgget.GroupMsg;
import com.forte.qqrobot.beans.messages.types.GroupMsgType;

import java.time.Instant;

/**
 * 群消息
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_groupMsg extends BaseMsgGet implements GroupMsg, Imageable, Anonable{

    /** 事件类型，此事件固定为2 */
//    private Integer type;
    /** 事件子类型，1/普通消息，2/匿名消息，3/系统消息 */
//    private Integer subType;

    /** 事件来源的QQ群号 */
    private String group;
    /** 触发事件(即发送消息)的QQ号 */
    private String qq;
    /** 消息内容 */
    private String msg;
    /** 对方使用的字体id */
    private String font;
    /** 消息ID，调用API deleteMsg[撤回消息] 时需要传递此参数 */
    private String msgID;

    private String originalMsg;
    /** 图片消息 */
    private MsgImage[] imageInfo;

    /** 匿名标识 */
    private String fromAnonymous;

    /** 匿名消息 */
    private AnonMsg anonymousInfo;



    @Override
    public GroupMsgType getType() {
        /* sub: 1/普通消息，2/匿名消息，3/系统消息*/
        int typeInt = getSubType() - 1;
        return GroupMsgType.of(typeInt);
    }

    /**
     * 获取群消息发送人的qq号
     */
    @Override
    public String getQQ() {
        return qq;
    }

    @Override
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
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

    public void setImageInfo(MsgImage[] imageInfo) {
        this.imageInfo = imageInfo;
    }

    public void setFromAnonymous(String fromAnonymous) {
        this.fromAnonymous = fromAnonymous;
    }

    public void setAnonymousInfo(AnonMsg anonymousInfo) {
        this.anonymousInfo = anonymousInfo;
    }

    /**
     * 图片消息原文
     */
    @Override
    public String getOriginalMsg() {
        return originalMsg;
    }

    /**
     * 获取图片信息封装类数组
     */
    @Override
    public MsgImage[] getImageInfo() {
        return new MsgImage[0];
    }

    @Override
    public String getFromAnonymous() {
        return fromAnonymous;
    }

    @Override
    public AnonMsg getAnonymousInfo() {
        return anonymousInfo;
    }
}
