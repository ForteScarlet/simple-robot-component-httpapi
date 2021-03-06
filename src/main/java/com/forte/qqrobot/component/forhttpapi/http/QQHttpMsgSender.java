package com.forte.qqrobot.component.forhttpapi.http;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.forte.qqrobot.beans.messages.types.GroupAddRequestType;
import com.forte.qqrobot.component.forhttpapi.HttpApiResourceDispatchCenter;
import com.forte.qqrobot.component.forhttpapi.HttpConfiguration;
import com.forte.qqrobot.component.forhttpapi.beans.request.get.Req_getRecord;
import com.forte.qqrobot.component.forhttpapi.beans.response.*;
import com.forte.qqrobot.exception.RobotRuntimeException;
import com.forte.qqrobot.log.QQLog;
import com.forte.qqrobot.utils.HttpClientUtil;

import java.util.Collection;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * http送信器
 *
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/30 10:32
 * @since JDK1.8
 **/
public class QQHttpMsgSender {

    /**
     * 响应信息字符串生成器 MsgCreator
     */
    private final QQJSONMsgCreator creator;

    /**
     * 私有构造
     */
    QQHttpMsgSender(QQJSONMsgCreator creator) {
        this.creator = creator;
    }

    /**
     * 工厂方法, 依靠启动器的初始化方法
     *
     * @return QQWebSocketMsgSender实例对象
     */
    public static QQHttpMsgSender build() {
        return new QQHttpMsgSender(HttpApiResourceDispatchCenter.getQQJSONMsgCreator());
    }

    /**
     * 工厂方法
     *
     * @return QQWebSocketMsgSender实例对象
     */
    public static QQHttpMsgSender build(QQJSONMsgCreator qqjsonMsgCreator) {
        return new QQHttpMsgSender(qqjsonMsgCreator);
    }

    //**************** 信息获取方法 ****************//

    //**************************************
    //*         获取信息-HTTP API
    //**************************************

    /**
     * 取匿名成员信息
     *
     * @param source 匿名成员的标识，即插件提交的参数fromAnonymous
     * @return 匿名成员信息
     */
    public Optional<Resp_getAnonymousInfo> getAnonymousInfo(String source) {
        String json = creator.getResponseJson_Req_getAnonymousInfo(source);
        return get(json, Resp_getAnonymousInfo.class);
    }

    /**
     * 取权限信息
     *
     * @return 权限信息
     */
    public Optional<Resp_getAuthInfo> getAuthInfo() {
        String json = creator.getResponseJson_Req_getAuthInfo();
        return get(json, Resp_getAuthInfo.class);
    }

    /**
     * 取群中被禁言成员列表
     *
     * @param group 群号
     * @return 群中被禁言成员列表
     */
    public Optional<Resp_getBanList> getBanList(String group) {
        String json = creator.getResponseJson_Req_getBanList(group);
        return get(json, Resp_getBanList.class);
    }

    /**
     * 取文件信息
     *
     * @param source 文件标识，即插件所提交的参数file
     * @return 件信息
     */
    public Optional<Resp_getFileInfo> getFileInfo(String source) {
        String json = creator.getResponseJson_Req_getFileInfo(source);
        return get(json, Resp_getFileInfo.class);
    }

    /**
     * 取好友列表
     *
     * @return 好友列表
     */
    public Optional<Resp_getFriendList> getFriendList() {
        String json = creator.getResponseJson_Req_getFriendList();
        return get(json, Resp_getFriendList.class, (res, type) -> {
            // 特殊处理
            JSONObject root = JSONObject.parseObject(res);
            // 获取result
            JSONObject result = root.getJSONObject("result").getJSONObject("result");
            Collection<Object> values = result.values();
            JSONArray array = new JSONArray();
            for (Object value : values) {
                if (value instanceof JSONObject) {
                    JSONArray mems = ((JSONObject) value).getJSONArray("mems");
                    if (mems != null) {
                        for (Object mem : mems) {
                            if (mem instanceof JSONObject) {
                                ((JSONObject) mem).put("originalData", mem.toString());
                            }
                        }
                    }
                }
                array.add(value);
            }

            // 将数组反向赋值回去
            root.put("result", array);
            return root.toJavaObject(Resp_getFriendList.class);
        });
    }

    /**
     * 取群作业列表
     *
     * @param group  群号
     * @param number 取出数量
     * @return
     */
    public Optional<Resp_getGroupHomeworkList> getGroupHomeworkList(String group, Integer number) {
        String json = creator.getResponseJson_Req_getGroupHomeworkList(group, number);
        return get(json, Resp_getGroupHomeworkList.class);
    }

    /**
     * 取群详细信息
     *
     * @param group 群号
     * @return 群详细信息
     */
    public Optional<Resp_getGroupInfo> getGroupInfo(String group) {
        String json = creator.getResponseJson_Req_getGroupInfo(group);
        return get(json, Resp_getGroupInfo.class);
    }

    /**
     * 取群链接列表
     *
     * @param group  群号
     * @param number 取出数量
     * @return 群链接列表
     */
    public Optional<Resp_getGroupLinkList> getGroupLinkList(String group, Integer number) {
        String json = creator.getResponseJson_Req_getGroupLinkList(group, number);
        return get(json, Resp_getGroupLinkList.class);
    }

    /**
     * 取群列表 (尚有异常
     *
     * @return 群列表
     */
    @Deprecated
    public Optional<Resp_getGroupList> getGroupList() {
        String json = creator.getResponseJson_Req_getGroupList();
        return get(json, Resp_getGroupList.class);
    }

    /**
     * 取群成员信息
     *
     * @param qq    qq号
     * @param group 群号
     * @param cache 使用缓存，0/不使用，1/使用
     * @return 群成员信息
     */
    public Optional<Resp_getGroupMemberInfo> getGroupMemberInfo(String qq, String group, Integer cache) {
        String json = creator.getResponseJson_Req_getGroupMemberInfo(qq, group, cache);
        return get(json, Resp_getGroupMemberInfo.class);
    }

    /**
     * 取群成员列表
     *
     * @param group 群号
     * @return 群成员列表
     */
    public Optional<Resp_getGroupMemberList> getGroupMemberList(String group) {
        String json = creator.getResponseJson_Req_getGroupMemberList(group);
        return get(json, Resp_getGroupMemberList.class);
    }

    /**
     * 取群公告列表
     *
     * @return 群公告列表
     */
    public Optional<Resp_getGroupNoteList> getGroupNoteList(String group, Integer number) {
        String json = creator.getResponseJson_Req_getGroupNoteList(group, number);
        return get(json, Resp_getGroupNoteList.class);
    }

    /**
     * 取群置顶公告
     *
     * @return 群置顶公告
     */
    public Optional<Resp_getGroupTopNote> getGroupTopNote(String group) {
        String json = creator.getResponseJson_Req_getGroupTopNote(group);
        return get(json, Resp_getGroupTopNote.class);
    }

    /**
     * 取图片信息 ※ 只能获取酷Q接收到的图片
     *
     * @param source   图片文件名
     * @param needFile 需要回传文件内容
     * @return 图片信息
     */
    public Optional<Resp_getImageInfo> getImageInfo(String source, Boolean needFile) {
        String json = creator.getResponseJson_Req_getImageInfo(source, needFile);
        return get(json, Resp_getImageInfo.class);
    }

    /**
     * 取登录QQ的信息
     *
     * @return 登录QQ的信息
     */
    public Optional<Resp_getLoginQQInfo> getLoginQQInfo() {
        String json = creator.getResponseJson_Req_getLoginQQInfo();
        return get(json, Resp_getLoginQQInfo.class);
    }

    /**
     * 批量取群头像
     *
     * @param groupList 群列表，每个群用-分开，可空，空时表示取所有群的头像链接
     * @return
     */
    public Optional<Resp_getMoreGroupHeadimg> getMoreGroupHeadimg(String groupList) {
        String json = creator.getResponseJson_Req_getMoreGroupHeadimg(groupList);
        return get(json, Resp_getMoreGroupHeadimg.class);
    }

    /**
     * 批量取QQ信息
     *
     * @param qqList Q列表，每个QQ用-分开
     * @return 批量取QQ信息
     */
    public Optional<Resp_getMoreQQInfo> getMoreQQInfo(String qqList) {
        String json = creator.getResponseJson_Req_getMoreQQInfo(qqList);
        return get(json, Resp_getMoreQQInfo.class);
    }

    /**
     * 接收语音文件 需要权限30
     *
     * @param source   文件名，必须是消息中的语音文件(file)
     * @param format   目标编码，默认MP3, 目前支持 mp3,amr,wma,m4a,spx,ogg,wav,flac
     * @param needFile 是否回传文件数据，true/回传，false/不回传
     * @return
     */
    public Optional<Resp_getRecord> getRecord(String source, Req_getRecord.RecordType format, Boolean needFile) {
        String json = creator.getResponseJson_Req_getRecord(source, format, needFile);
        return get(json, Resp_getRecord.class);
    }

    /**
     * 取运行状态
     *
     * @return 运行状态
     */
    public Optional<Resp_getRunStatus> getRunStatus() {
        String json = creator.getResponseJson_Req_getRunStatus();
        return get(json, Resp_getRunStatus.class);
    }

    /**
     * 取群文件列表
     *
     * @param group 群号
     * @return 群文件列表
     */
    @Deprecated
    public Optional<Resp_getShareList> getShareList(String group) {
        String json = creator.getResponseJson_Req_getShareList(group);
        return get(json, Resp_getShareList.class);
    }

    /**
     * 取陌生人信息
     * 需要权限131
     * 可能需要权限20
     *
     * @param cache 使用缓存，true/使用，false/不使用
     * @return
     */
    public Optional<Resp_getStrangerInfo> getStrangerInfo(String qq, Boolean cache) {
        String json = creator.getResponseJson_Req_getStrangerInfo(qq, cache);
        return get(json, Resp_getStrangerInfo.class);
    }

    /**
     * 获取版本？
     *
     * @return 版本？
     */
    public Optional<Resp_getVersion> getVersion() {
        String json = creator.getResponseJson_Req_getVersion();
        return get(json, Resp_getVersion.class);
    }

    /**
     * 通过HTTP API插件获取所需消息
     *
     * @param json     json参数字符串
     * @param beanType bean类型
     */
    public <T extends RespBean> Optional<T> get(String json, Class<T> beanType, BiFunction<String, Class<T>, T> parseFunction) {
        try {
            //获取HTTP API请求地址参数
            HttpConfiguration httpConfiguration = HttpApiResourceDispatchCenter.getHttpConfiguration();
            String url = httpConfiguration.getHttpRequestUrl();
            //返回参数
            String response = HttpClientUtil.post(url, json);
            //转化为bean对象，并做防止空指针的处理
            return Optional.ofNullable(response).map(res -> parseFunction.apply(res, beanType));

        } catch (Exception e) {
            QQLog.error("信息获取失败!", e);
            return Optional.empty();
        }
    }

    /**
     * 通过HTTP API插件获取所需消息
     *
     * @param json     json参数字符串
     * @param beanType bean类型
     */
    public <T extends RespBean> Optional<T> get(String json, Class<T> beanType) {
        return get(json, beanType, (res, type) -> {
            JSONObject jsonObject = JSON.parseObject(res);
            // 判断是否成功
            final Integer status = jsonObject.getInteger("status");
            if(status != 0){
                throw new RobotRuntimeException("获取信息失败：" + jsonObject.getString("errmsg"));
            }
            jsonObject.put("originalData", res);
            return jsonObject.toJavaObject(type);
        });
    }

    //**************** 信息发送方法 ****************//

    //**************************************
    //*         发送信息-HTTP API
    //**************************************


    /**
     * 发送讨论组消息
     *
     * @param group 群号
     * @param msg   消息内容
     * @return 是否成功
     */
    public boolean sendDiscussMsg(String group, String msg) {
        return send(creator.getResponseJson_sendDisGroupMsg(group, msg));
    }

    /**
     * 发送群消息
     *
     * @param group 群号
     * @param msg   消息内容
     * @return 是否成功
     */
    public boolean sendGroupMsg(String group, String msg) {
        return send(creator.getResponseJson_sendGroupMsg(group, msg));
    }

    /**
     * 发送私聊消息
     *
     * @param qq  qq号
     * @param msg 消息内容
     * @return 是否成功
     */
    public boolean sendPrivateMsg(String qq, String msg) {
        return send(creator.getResponseJson_sendMsgPrivate(qq, msg));
    }


    /**
     * 送花
     *
     * @param group 群号
     * @param qq    qq号
     * @return 是否成功
     */
    public boolean sendFlower(String group, String qq) {
        return send(creator.getResponseJson_sendFlower(group, qq));
    }


    /**
     * 赞
     *
     * @param qq    qq号
     * @param times 赞次数
     * @return 是否成功
     */
    public boolean sendLike(String qq, int times) {
        return send(creator.getResponseJson_sendPraise(qq, times));
    }


    //**************************************
    //*             设置类型消息
    //**************************************

    /**
     * 好友添加请求
     *
     * @param flag       添加请求标识
     * @param friendName 好友备注
     * @param agree      是否同意
     * @return 是否成功
     */
    public boolean setFriendAddRequest(String flag, String friendName, boolean agree) {
        return set(creator.getResponseJson_setFriendAddRequest(flag, agree, friendName));
    }


    /**
     * 群添加请求
     *
     * @param flag        标识
     * @param requestType 添加类型
     * @param agree       是否同意
     * @param why         为什么拒绝
     * @return 是否成功
     */
    public boolean setGroupAddRequest(String flag, GroupAddRequestType requestType, boolean agree, String why) {
        return set(creator.getResponseJson_setGroupJoinResquest(why, requestType, agree, flag));
    }


    /**
     * 设置群管理员
     *
     * @param group 群号
     * @param qq    qq号
     * @param set   是否设置为管理员
     * @return 是否成功
     */
    public boolean setGroupAdmin(String group, String qq, boolean set) {
        return set(creator.getResponseJson_setGroupAdmin(qq, group, set));
    }

    /**
     * 是否允许群匿名聊天
     *
     * @param group 群号
     * @param agree 是否开启
     * @return 是否成功
     */
    public boolean setGroupAnonymous(String group, boolean agree) {
        return set(creator.getResponseJson_setGroupAno(group, agree));
    }

    /**
     * 匿名成员禁言
     *
     * @param group 群号
     * @param flag  匿名标识
     * @param time  时长
     * @return 是否成功
     */
    public boolean setGroupAnonymousBan(String group, String flag, Long time) {
        return set(creator.getResponseJson_setAnoGroupMemberBanned(group, flag, time));
    }

    /**
     * 群禁言
     *
     * @param group 群号
     * @param qq    qq号
     * @param time  时长
     * @return 是否成功
     */
    public boolean setGroupBan(String group, String qq, Long time) {
        return set(creator.getResponseJson_setGroupMemberBanned(qq, group, time));

    }

    /**
     * 设置群成员名片
     *
     * @param group
     * @param qq
     * @param card
     * @return
     */
    public boolean setGroupCard(String group, String qq, String card) {
        return set(creator.getResponseJson_setGroupMemberCard(qq, group, card));

    }

    /**
     * 删除群文件
     *
     * @param group 群号
     * @param flag  文件标识
     * @return 是否成功
     */
    public boolean setGroupFileDelete(String group, String flag) {
        return set(creator.getResponseJson_setGroupFileDelete(group, flag));
    }


    /**
     * 退出讨论组
     *
     * @param group 讨论组号
     * @return 是否成功
     */
    public boolean setDiscussLeave(String group) {
        return set(creator.getResponseJson_setDisGroupExit(group));
    }

    /**
     * 退出群
     *
     * @param group 群号
     * @return 是否成功
     */
    public boolean setGroupLeave(String group) {
        return set(creator.getResponseJson_setGroupExit(group, false));
    }

    /**
     * 踢出群成员
     *
     * @param group    群号
     * @param qq       成员qq号
     * @param dontBack 禁止再回来了
     * @return 是否成功
     */
    public boolean setGroupMemberKick(String group, String qq, boolean dontBack) {
        return set(creator.getResponseJson_setGroupMemberRemove(qq, group, dontBack));
    }

    /**
     * 群签到
     *
     * @param group 群号
     * @return 是否成功
     */
    public boolean setGroupSign(String group) {
        return set(creator.getResponseJson_setGroupSign(group));
    }

    /**
     * 设置群成员专属头衔
     *
     * @param group 群号
     * @param qq    qq号
     * @param title 头衔
     * @param time  时长
     * @return
     */
    public boolean setGroupExclusiveTitle(String group, String qq, String title, Long time) {
        return set(creator.getResponseJson_setGroupMemberSpecialTitle(qq, group, time, title));

    }

    /**
     * 设置全群禁言
     *
     * @param group 群号
     * @param in    是否开启
     * @return 是否成功
     */
    public boolean setGroupWholeBan(String group, boolean in) {
        return set(creator.getResponseJson_setAllGroupBanned(group, in));
    }

    /**
     * 撤回消息
     *
     * @param flag 消息标识
     * @return 是否成功
     */
    public boolean setMsgRecall(String flag) {
        return set(creator.getResponseJson_setMsgDelete(flag));
    }

    /**
     * 打卡
     *
     * @return 是否成功
     */
    public boolean setSign() {
        return set(creator.getResponseJson_setSign());
    }

    /**
     * 发送消息
     * 用httpclient发送
     */
    public boolean send(String json) {
        if (json == null) {
            json = "null";
        }
        try {
            //获取HTTP API请求地址参数
            HttpConfiguration httpConfiguration = HttpApiResourceDispatchCenter.getHttpConfiguration();
            String url = httpConfiguration.getHttpRequestUrl();
            HttpClientUtil.post(url, json);
            return true;
        } catch (Exception e) {
            QQLog.error("消息发送失败!", e);
            return false;
        }
    }

    /**
     * 设置消息
     */
    public boolean set(String json) {
        return send(json);
    }
}
