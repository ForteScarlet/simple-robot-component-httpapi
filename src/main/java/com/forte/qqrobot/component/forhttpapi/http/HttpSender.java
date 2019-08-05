package com.forte.qqrobot.component.forhttpapi.http;


import com.forte.qqrobot.beans.messages.result.*;
import com.forte.qqrobot.beans.messages.types.GroupAddRequestType;
import com.forte.qqrobot.component.forhttpapi.HttpApiResourceDispatchCenter;
import com.forte.qqrobot.sender.senderlist.RootSenderList;

/**
 * http送信器，此送信器不依赖于连接，使用httpclient即可
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/30 11:16
 * @since JDK1.8
 **/
public class HttpSender implements RootSenderList {

    /** 真正的送信器 */
    private final QQHttpMsgSender msgSender;

    /**
     * 构造
     * @param qqHttpMsgSender 真正的送信器
     */
    private HttpSender(QQHttpMsgSender qqHttpMsgSender){
        this.msgSender = qqHttpMsgSender;
    }

    /**
     * 工厂方法，请确保公共资源中已经存在QQHttpMsgSender对象
     * @return HttpSender实例
     */
    public static HttpSender build(){
        return new HttpSender(HttpApiResourceDispatchCenter.getQQHttpMsgSender());
    }
    /**
     * 工厂方法
     * @return HttpSender实例
     */
    public static HttpSender build(QQHttpMsgSender qqHttpMsgSender){
        return new HttpSender(qqHttpMsgSender);
    }


    /**
     * 取匿名成员信息
     * 一般是使用匿名标识来获取
     *
     * @param flag
     * @return 匿名成员信息
     */
    @Override
    public AnonInfo getAnonInfo(String flag) {
        return msgSender.getAnonymousInfo(flag).orElse(null);
    }

    /**
     * 获取权限信息
     * 一般不需要参数
     *
     * @return 权限信息
     */
    @Override
    public AuthInfo getAuthInfo() {
        return msgSender.getAuthInfo().orElse(null);
    }

    /**
     * 获取封禁成员列表
     *
     * @param group 群号
     * @return 封禁列表
     */
    @Override
    public BanList getBanList(String group) {
        return msgSender.getBanList(group).orElse(null);
    }

    /**
     * 获取群文件信息
     *
     * @param flag 文件标识
     * @return 群文件信息
     */
    @Override
    public FileInfo getFileInfo(String flag) {
        return msgSender.getFileInfo(flag).orElse(null);
    }

    /**
     * 获取好友列表
     * @return 好友列表
     */
    @Override
    public FriendList getFriendList() {
        return msgSender.getFriendList().orElse(null);
    }

    /**
     * 取群作业列表
     *
     * @param group  群号
     * @param number 获取数量
     * @return 群作业列表
     */
    @Override
    public GroupHomeworkList getGroupHomeworkList(String group, int number) {
        return msgSender.getGroupHomeworkList(group, number).orElse(null);
    }

    /**
     * 取群信息
     *
     * @param group 群号
     * @param cache 是否使用缓存
     * @return 群信息
     */
    @Override
    public GroupInfo getGroupInfo(String group, boolean cache) {
        return msgSender.getGroupInfo(group).orElse(null);
    }

    /**
     * 取群链接列表
     *
     * @param group  群号
     * @param number 获取数量
     * @return 群链接
     */
    @Override
    public GroupLinkList getGroupLinkList(String group, int number) {
        return msgSender.getGroupLinkList(group, number).orElse(null);
    }

    /**
     * 取群列表
     *
     * @return 群列表
     */
    @Override
    public GroupList getGroupList() {
        return msgSender.getGroupList().orElse(null);
    }


    /**
     * 取群成员信息
     *
     * @param group 群号
     * @param QQ    QQ号
     * @param cache 是否使用缓存
     * @return 群成员信息
     */
    @Override
    public GroupMemberInfo getGroupMemberInfo(String group, String QQ, boolean cache) {
        return msgSender.getGroupMemberInfo(QQ, group, cache ? 1 : 0).orElse(null);
    }

    /**
     * 取群成员列表
     *
     * @param group 群号
     * @return 成员列表
     */
    @Override
    public GroupMemberList getGroupMemberList(String group) {
        return msgSender.getGroupMemberList(group).orElse(null);
    }

    /**
     * 取群公告列表
     *
     * @param group  群号
     * @param number 数量
     * @return 群公告列表
     */
    @Override
    public GroupNoteList getGroupNoteList(String group, int number) {
        return msgSender.getGroupNoteList(group, number).orElse(null);
    }

    /**
     * 取置顶群公告
     *
     * @param group 群号
     * @return 置顶群公告
     */
    @Override
    public GroupTopNote getGroupTopNote(String group) {
        return msgSender.getGroupTopNote(group).orElse(null);
    }

    /**
     * 获取图片信息
     *
     * @param flag 图片文件名或标识
     * @return 图片信息
     */
    @Override
    public ImageInfo getImageInfo(String flag) {
        return msgSender.getImageInfo(flag, false).orElse(null);
    }

    /**
     * 获取登录的QQ的信息
     *
     * @return 登录QQ的信息
     */
    @Override
    public LoginQQInfo getLoginQQInfo() {
        return msgSender.getLoginQQInfo().orElse(null);
    }

    /**
     * 获取群共享文件列表
     *
     * @param group
     * @return 共享文件列表
     */
    @Override
    public ShareList getShareList(String group) {
        return msgSender.getShareList(group).orElse(null);
    }

    /**
     * 取陌生人信息
     *
     * @param QQ    陌生人的QQ号
     * @param cache 是否使用缓存
     * @return
     */
    @Override
    public StrangerInfo getStrangerInfo(String QQ, boolean cache) {
        return msgSender.getStrangerInfo(QQ, cache).orElse(null);
    }

    //**************************************
    //*             消息发送
    //**************************************


    /**
     * 发送讨论组消息
     *
     * @param group 群号
     * @param msg   消息内容
     */
    @Override
    public boolean sendDiscussMsg(String group, String msg) {
        return msgSender.sendDiscussMsg(group, msg);
    }

    /**
     * 发送群消息
     *
     * @param group 群号
     * @param msg   消息内容
     */
    @Override
    public boolean sendGroupMsg(String group, String msg) {
        return msgSender.sendGroupMsg(group, msg);
    }

    /**
     * 发送私聊信息
     *
     * @param QQ  QQ号
     * @param msg 消息内容
     */
    @Override
    public boolean sendPrivateMsg(String QQ, String msg) {
        return msgSender.sendPrivateMsg(QQ, msg);
    }

    /**
     * 送花
     *
     * @param group 群号
     * @param QQ    QQ号
     */
    @Override
    public boolean sendFlower(String group, String QQ) {
        return msgSender.sendFlower(group, QQ);
    }

    /**
     * 发送名片赞
     *
     * @param QQ    QQ号
     * @param times 次数
     */
    @Override
    public boolean sendLike(String QQ, int times) {
        return msgSender.sendLike(QQ, times);
    }

    /**
     * 好友请求申请
     *
     * @param flag       一般会有个标识
     * @param friendName 如果通过，则此参数为好友备注
     * @param agree      是否通过
     */
    @Override
    public boolean setFriendAddRequest(String flag, String friendName, boolean agree) {
        return msgSender.setFriendAddRequest(flag, friendName, agree);
    }

    /**
     * 群添加申请
     *
     * @param flag        一般会有个标识
     * @param requestType 加群类型  邀请/普通添加
     * @param agree       是否同意
     * @param why         如果拒绝，则此处为拒绝理由
     */
    @Override
    public boolean setGroupAddRequest(String flag, GroupAddRequestType requestType, boolean agree, String why) {
        return msgSender.setGroupAddRequest(flag, requestType, agree, why);
    }

    /**
     * 设置群管理员
     *
     * @param group 群号
     * @param QQ    qq号
     * @param set   是否设置为管理员
     */
    @Override
    public boolean setGroupAdmin(String group, String QQ, boolean set) {
        return msgSender.setGroupAdmin(group, QQ, set);
    }

    /**
     * 是否允许群匿名聊天
     *
     * @param group 群号
     * @param agree 是否允许
     */
    @Override
    public boolean setGroupAnonymous(String group, boolean agree) {
        return msgSender.setGroupAnonymous(group, agree);
    }

    /**
     * 设置匿名成员禁言
     *
     * @param group 群号
     * @param flag  匿名成员标识
     * @param time  时长，一般是以分钟为单位
     */
    @Override
    public boolean setGroupAnonymousBan(String group, String flag, long time) {
        return msgSender.setGroupAnonymousBan(group, flag, time);
    }

    /**
     * 设置群禁言
     *
     * @param group 群号
     * @param QQ    QQ号
     * @param time  时长，一般是以分钟为单位
     */
    @Override
    public boolean setGroupBan(String group, String QQ, long time) {
        return msgSender.setGroupBan(group, QQ, time);
    }

    /**
     * 设置群成员名片
     *
     * @param group 群号
     * @param QQ    QQ号
     * @param card  名片
     */
    @Override
    public boolean setGroupCard(String group, String QQ, String card) {
        return msgSender.setGroupCard(group, QQ, card);
    }



    /**
     * 删除群文件<br>
     * ! 此接口可能不成熟
     *
     * @param group 群号
     * @param flag  一般应该会有个标识
     */
    @Override
    public boolean setGroupFileDelete(String group, String flag) {
        return msgSender.setGroupFileDelete(group, flag);
    }

    /**
     * 退出讨论组
     *
     * @param group 讨论组号
     */
    @Override
    public boolean setDiscussLeave(String group) {
        return msgSender.setDiscussLeave(group);
    }

    /**
     * 退出群
     *
     * @param group 群号
     */
    @Override
    public boolean setGroupLeave(String group) {
        return msgSender.setGroupLeave(group);
    }

    /**
     * 踢出群成员
     *
     * @param group    群号
     * @param QQ       QQ号
     * @param dontBack 是否拒绝再次申请
     */
    @Override
    public boolean setGroupMemberKick(String group, String QQ, boolean dontBack) {
        return msgSender.setGroupMemberKick(group, QQ, dontBack);
    }

    /**
     * 群签到
     *
     * @param group 群号
     */
    @Override
    public boolean setGroupSign(String group) {
        return msgSender.setGroupSign(group);
    }

    /**
     * 设置群成员专属头衔
     *
     * @param group 群号
     * @param QQ    QQ号
     * @param title 头衔
     * @param time  有效时长，一般为分钟吧
     */
    @Override
    public boolean setGroupExclusiveTitle(String group, String QQ, String title, long time) {
        return msgSender.setGroupExclusiveTitle(group, QQ, title, time);
    }

    /**
     * 设置全群禁言
     *
     * @param group 群号
     * @param in    是否开启全群禁言
     */
    @Override
    public boolean setGroupWholeBan(String group, boolean in) {
        return msgSender.setGroupWholeBan(group, in);
    }

    /**
     * 消息撤回 似乎只需要一个消息ID即可
     * 需要pro
     *
     * @param flag 消息标识
     */
    @Override
    public boolean setMsgRecall(String flag) {
        return msgSender.setMsgRecall(flag);
    }

    /**
     * 打卡
     */
    @Override
    public boolean setSign() {
        return msgSender.setSign();
    }
}
