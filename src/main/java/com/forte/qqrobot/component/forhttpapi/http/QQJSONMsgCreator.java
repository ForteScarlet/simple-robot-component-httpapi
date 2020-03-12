package com.forte.qqrobot.component.forhttpapi.http;

import com.alibaba.fastjson.JSON;
import com.forte.qqrobot.beans.messages.types.GroupAddRequestType;
import com.forte.qqrobot.component.forhttpapi.beans.request.get.*;
import com.forte.qqrobot.component.forhttpapi.beans.request.send.*;
import com.forte.qqrobot.component.forhttpapi.beans.request.set.*;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * QQ交互信息JSON生成器，用于生成返回给服务器的方法
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/8 18:37
 * @since JDK1.8
 **/
public class QQJSONMsgCreator {

    /**
     * 创建一个参数map
     * @param params 参数集，数组每一个元素的0索引为key，1索引为value
     * @return map
     */
    private static Map<String, Object> createParamMap(Object[]... params){
        return Arrays.stream(params).collect(Collectors.toMap(p -> p[0]+"", p -> p[1]));
    }

    /**
     * 创建一个初始参数map
     * @param init map初始大小
     * @return map
     */
    private static Map<String, Object> createParamMap(int init){
        return new HashMap<>(init);
    }

    /**
     * 将一个空对象和map参数集合传进来，返回封装完的json字符串
     * @return
     */
    private static String mapToBeanJson(Object bean, Map<String, Object> params){
        //封装对象
        try {
            //将参数封装进去，然后转化为JSON对象
            BeanUtils.populate(bean, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.err.println("参数封装失败！");
            e.printStackTrace();
        }

        return JSON.toJSONString(bean);
    }


    /* ———————————————— 参数转JSON方法集 ———————————————— */

    //**************************************
    //*             发送的消息
    //**************************************


    /**
     * 讨论组消息
     * @return 讨论组消息
     */
    String getResponseJson_sendDisGroupMsg(String group, String msg){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group},
                new Object[]{"msg", msg}
        );

        return mapToBeanJson(new Req_sendDiscussMsg(), paramMap);
    }

    /**
     * 群消息
     * @return 群消息
     */
    String getResponseJson_sendGroupMsg(String group, String msg){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group},
                new Object[]{"msg", msg}
        );

        return mapToBeanJson(new Req_sendGroupMsg(), paramMap);
    }

    /**
     * 私信消息
     * @param qq  qq号
     * @param msg   消息
     * @return 私信
     */
    String getResponseJson_sendMsgPrivate(String qq, String msg){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qq", qq},
                new Object[]{"msg", msg}
        );
        return mapToBeanJson(new Req_sendPrivateMsg(), paramMap);
    }

    /**
     * 赞
     * @param qq qq号
     * @param times 次数
     * @return 赞
     */
    String getResponseJson_sendPraise(String qq, int times){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qq", qq},
                new Object[]{"number", times}
        );
        return mapToBeanJson(new Req_sendLike(), paramMap);
    }

    /**
     * 送花
     * @param group 群号
     * @param qq    qq
     * @return 送花
     */
    String getResponseJson_sendFlower(String group, String qq){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group},
                new Object[]{"qq", qq}
        );
        return mapToBeanJson(new Req_sendFlower(), paramMap);
    }


    //**************************************
    //*             设置的消息 - socket
    //**************************************




    /**
     * 设置全群禁言
     * @param group   群号
     * @param open 是否开启禁言
     * @return  全群禁言
     */
    String getResponseJson_setAllGroupBanned(String group, boolean open){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group},
                new Object[]{"open", open}
        );

        return mapToBeanJson(new Req_setGroupWholeBan(), paramMap);
    }

    /**
     * 消息撤回
     * @param msgID 消息ID
     * @return      消息撤回
     */
    String getResponseJson_setMsgDelete(String msgID){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"msgID", msgID}
        );

        return mapToBeanJson(new Req_setMsgDelete(), paramMap);
    }

    /**
     * 设置匿名群员禁言
     * @param group   群号
     * @param time  时间，单位 秒
     * @param anonymous 匿名群员名称，大概
     * @return 设置匿名群员禁言
     */
    String getResponseJson_setAnoGroupMemberBanned(String group, String anonymous, Long time){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group},
                new Object[]{"anonymous", anonymous},
                new Object[]{"time", time}
        );

        return mapToBeanJson(new Req_setGroupAnonymousBan(), paramMap);
    }

    /**
     * 讨论组退出
     * @param group 讨论组id
     * @return 讨论组退出
     */
    String getResponseJson_setDisGroupExit(String group){
        Map<String, Object> paramMap = createParamMap(new Object[]{"group", group});
        return mapToBeanJson(new Req_setDiscussLeave(), paramMap);
    }

    /**
     * 好友添加请求
     * @param name      备注
     * @param subType   是否通过
     * @param responseFlag 请求标识
     * @return
     */
    String getResponseJson_setFriendAddRequest(String responseFlag, boolean subType, String name){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"responseFlag", responseFlag},
                new Object[]{"subType", subType ? 1 : 2},
                new Object[]{"name", name}
        );
        return mapToBeanJson(new Req_setFriendAddRequest(), paramMap);
    }

    /**
     * 设置群管理员
     * @param qq      qq号
     * @param group   群号
     * @param become  是否设置为管理员
     * @return 群管理员
     */
    String getResponseJson_setGroupAdmin(String qq, String group, boolean become){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qq", qq},
                new Object[]{"group", group},
                new Object[]{"become", become}
        );
        return mapToBeanJson(new Req_setGroupAdmin(), paramMap);
    }

    /**
     * 群匿名设置
     * @param group   群号
     * @param open   是否开启群匿名
     * @return  群匿名设置
     */
    String getResponseJson_setGroupAno(String group, boolean open){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group},
                new Object[]{"open", open}
        );
        return mapToBeanJson(new Req_setGroupAnonymous(), paramMap);
    }

    /**
     * 置群退出
     * @param group   群号
     * @param disband 解散/true, 普通的退出/false
     * @return 置群退出
     */
    String getResponseJson_setGroupExit(String group, boolean disband){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group},
                new Object[]{"disband", disband}
        );
        return mapToBeanJson(new Req_setGroupLeave(), paramMap);
    }

    /**
     *  置群添加请求
     * @param msg
     * @param subType
     * @param agree
     * @param responseFlag
     * @return  置群添加请求
     */
    String getResponseJson_setGroupJoinResquest(String msg, GroupAddRequestType subType, boolean agree, String responseFlag){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"msg", msg},
                new Object[]{"type", agree ? 1 : 2},
                new Object[]{"subType", subType.TYPE == 1 ? 2 : 1},
                new Object[]{"responseFlag", responseFlag}
        );

        return mapToBeanJson(new Req_setGroupAddRequest(), paramMap);
    }

    /**
     * 置群员禁言
     * @param qq      qq号
     * @param group   群号
     * @param time  禁言时间，单位为秒
     * @return 置群员禁言
     */
    String getResponseJson_setGroupMemberBanned(String qq, String group, long time){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qq", qq},
                new Object[]{"group", group},
                new Object[]{"time", time}
        );
        return mapToBeanJson(new Req_setGroupBan(), paramMap);
    }

    /**
     * 置群成员名片
     * @param qq      qq号
     * @param group   群号
     * @param card   新名片
     * @return  群成员名片
     */
    String getResponseJson_setGroupMemberCard(String qq, String group, String card){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qq", qq},
                new Object[]{"group", group},
                new Object[]{"card", card}
        );
        return mapToBeanJson(new Req_setGroupCard(), paramMap);
    }

    /**
     * 删除群文件
     * @param group 群号
     * @param id    文件id
     * @return      是否成功
     */
    String getResponseJson_setGroupFileDelete(String group, String id){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group},
                new Object[]{"id", id}
        );
        return mapToBeanJson(new Req_setGroupFileDelete(), paramMap);
    }

    /**
     * 置群员移除
     * @param qq              移除的qq号
     * @param group          群号
     * @param refuseJoin    是否拒绝添加请求
     * @return
     */
    String getResponseJson_setGroupMemberRemove(String qq, String group, boolean refuseJoin){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qq", qq},
                new Object[]{"group", group},
                new Object[]{"refuseJoin", refuseJoin}
        );
        return mapToBeanJson(new Req_setGroupKick(), paramMap);
    }

    /**
     * 群签到
     * @param group 群号
     * @return
     */
    String getResponseJson_setGroupSign(String group){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group == null ? '0' : group}
        );
        return mapToBeanJson(new Req_setGroupSign(), paramMap);
    }

    /**
     * 打卡
     */
    String getResponseJson_setSign(){
        Map<String, Object> paramMap = Collections.emptyMap();
        return mapToBeanJson(new Req_setGroupSign(), paramMap);
    }

    /**
     *  置群成员专属头衔
     * @param qq              qq号
     * @param group           群号
     * @param time          设置时间，单位大概是秒
     * @param tip   专属头衔
     * @return  群成员专属头衔
     */
    String getResponseJson_setGroupMemberSpecialTitle(String qq, String group, long time, String tip){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qq", qq},
                new Object[]{"group", group},
                new Object[]{"time", time},
                new Object[]{"tip", tip}
        );
        return mapToBeanJson(new Req_setGroupSpecialTitle(), paramMap);
    }


    //**************************************
    //*             信息请求的消息 - socket
    //**************************************


    /**
     * 请求获取群列表信息
     * @param QQID 作为标记
     * @return 请求群列表信息
     */
    @Deprecated
    String getResponseJson_InfoForLoginInGroups(String QQID){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"QQID", QQID}
        );
        return mapToBeanJson(new Req_getGroupList(), paramMap);
    }

    /**
     * 请求获取群中某用户信息
     * @param group   群号
     * @param qq      群员qq号
     * @param cache   1或0之类的
     * @return 请求获取群中某用户信息
     */
    @Deprecated
    String getResponseJson_InfoGroupMember(String qq, String group, int cache){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qq", qq},
                new Object[]{"group", group},
                new Object[]{"cache", cache}
        );
        return mapToBeanJson(new Req_getGroupMemberInfo(), paramMap);
    }

    /**
     * 请求获取当前账号的昵称
     * @return 请求获取当前账号的昵称
     */
    @Deprecated
    String getResponseJson_LoginQQInfo(){
        return JSON.toJSONString(new Req_getLoginQQInfo());
    }

    /**
     * 请求获取陌生人信息
     * @param qq      qq号
     * @param cache   是否使用缓存，true/false
     * @return  请求获取陌生人信息
     */
    @Deprecated
    String getResponseJson_InfoStranger(String qq, boolean cache){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qq", qq},
                new Object[]{"cache", cache}
        );
        return mapToBeanJson(new Req_getStrangerInfo(), paramMap);
    }


    //**************************************
    //*             信息请求的消息 - HTTP API
    //**************************************

    /**
     * 取匿名成员信息
     * @param source 匿名成员的标识，即插件提交的参数fromAnonymous
     * @return 匿名成员信息
     */
    String getResponseJson_Req_getAnonymousInfo(String source){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"source", source}
        );
        return mapToBeanJson(new Req_getAnonymousInfo(), paramMap);
    }

    /**
     * 取权限信息
     * @return 权限信息
     */
    String getResponseJson_Req_getAuthInfo(){
        Map<String, Object> paramMap = createParamMap(0);
        return mapToBeanJson(new Req_getAuthInfo(), paramMap);
    }

    /**
     * 取群中被禁言成员列表
     * @param group 群号
     * @return 群中被禁言成员列表
     */
    String getResponseJson_Req_getBanList(String group){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group}
        );

        return mapToBeanJson(new Req_getBanList(), paramMap);
    }

    /**
     * 取文件信息
     * @param source 文件标识，即插件所提交的参数file
     * @return 件信息
     */
    String getResponseJson_Req_getFileInfo(String source){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"source", source}
        );
        return mapToBeanJson(new Req_getFileInfo(), paramMap);
    }

    /**
     * 取好友列表 (尚且有异常
     * @return 好友列表
     */
    String getResponseJson_Req_getFriendList(){
        Map<String, Object> paramMap = createParamMap(0);
        return mapToBeanJson(new Req_getFriendList(), paramMap);
    }

    /**
     * 取群作业列表
     * @param group 群号
     * @param number 取出数量
     * @return
     */
    String getResponseJson_Req_getGroupHomeworkList(String group, Integer number){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group},
                new Object[]{"number", number}
        );
        return mapToBeanJson(new Req_getGroupHomeworkList(), paramMap);
    }

    /**
     * 取群详细信息
     * @param group 群号
     * @return 群详细信息
     */
    String getResponseJson_Req_getGroupInfo(String group){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group}
        );
        return mapToBeanJson(new Req_getGroupInfo(), paramMap);
    }

    /**
     * 取群链接列表
     * @param group 群号
     * @param number 取出数量
     * @return 群链接列表
     */
    String getResponseJson_Req_getGroupLinkList(String group, Integer number){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group},
                new Object[]{"number", number}
        );
        return mapToBeanJson(new Req_getGroupLinkList(), paramMap);
    }

    /**
     * 取群列表 (尚有异常
     * @return 群列表
     */
    @Deprecated
    String getResponseJson_Req_getGroupList(){
        Map<String, Object> paramMap = createParamMap(0);
        return mapToBeanJson(new Req_getGroupList(), paramMap);
    }

    /**
     * 取群成员信息
     * @param qq qq号
     * @param group 群号
     * @param cache 使用缓存，0/不使用，1/使用
     * @return 群成员信息
     */
    String getResponseJson_Req_getGroupMemberInfo(String qq, String group, Integer cache){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qq", qq},
                new Object[]{"group", group},
                new Object[]{"cache", cache}
        );
        return mapToBeanJson(new Req_getGroupMemberInfo(), paramMap);
    }

    /**
     * 取群成员列表
     * @param group 群号
     * @return 群成员列表
     */
    String getResponseJson_Req_getGroupMemberList(String group){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group}
        );
        return mapToBeanJson(new Req_getGroupMemberList(), paramMap);
    }

    /**
     * 取群公告列表
     * @return 群公告列表
     */
    String getResponseJson_Req_getGroupNoteList(String group, Integer number){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group},
                new Object[]{"number", number}
        );
        return mapToBeanJson(new Req_getGroupNoteList(), paramMap);
    }

    /**
     * 取群置顶公告
     * @return 群置顶公告
     */
    String getResponseJson_Req_getGroupTopNote(String group){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group}
        );
        return mapToBeanJson(new Req_getGroupTopNote(), paramMap);
    }

    /**
     * 取图片信息 ※ 只能获取酷Q接收到的图片
     * @param source 图片文件名
     * @param needFile 需要回传文件内容
     * @return 图片信息
     */
    String getResponseJson_Req_getImageInfo(String source, Boolean needFile){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"source", source},
                new Object[]{"needFile", needFile}
        );
        return mapToBeanJson(new Req_getImageInfo(), paramMap);
    }

    /**
     * 取登录QQ的信息
     * @return 登录QQ的信息
     */
    String getResponseJson_Req_getLoginQQInfo(){
        Map<String, Object> paramMap = createParamMap(0);
        return mapToBeanJson(new Req_getLoginQQInfo(), paramMap);
    }

    /**
     * 批量取群头像
     * @param groupList 群列表，每个群用-分开，可空，空时表示取所有群的头像链接
     * @return
     */
    String getResponseJson_Req_getMoreGroupHeadimg(String groupList){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"groupList", groupList}
        );
        return mapToBeanJson(new Req_getMoreGroupHeadimg(), paramMap);
    }

    /**
     * 批量取QQ信息
     * @param qqList Q列表，每个QQ用-分开
     * @return 批量取QQ信息
     */
    String getResponseJson_Req_getMoreQQInfo(String qqList){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qqList", qqList}
        );
        return mapToBeanJson(new Req_getMoreQQInfo(), paramMap);
    }

    /**
     * 接收语音文件 需要权限30
     * @param source 文件名，必须是消息中的语音文件(file)
     * @param format 目标编码，默认MP3, 目前支持 mp3,amr,wma,m4a,spx,ogg,wav,flac
     * @param needFile 是否回传文件数据，true/回传，false/不回传
     * @return
     */
    String getResponseJson_Req_getRecord(String source, Req_getRecord.RecordType format, Boolean needFile){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"source", source},
                new Object[]{"format", format},
                new Object[]{"needFile", needFile}
        );

        return mapToBeanJson(new Req_getRecord(), paramMap);
    }

    /**
     * 取运行状态
     * @return 运行状态
     */
    String getResponseJson_Req_getRunStatus(){
        Map<String, Object> paramMap = createParamMap(0);
        return mapToBeanJson(new Req_getRunStatus(), paramMap);
    }

    /**
     * 取群文件列表
     * @param group 群号
     * @return 群文件列表
     */
    String getResponseJson_Req_getShareList(String group){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"group", group}
        );
        return mapToBeanJson(new Req_getShareList(), paramMap);
    }

    /**
     * 取陌生人信息
     * 需要权限131
     * 可能需要权限20
     * @param cache 使用缓存，true/使用，false/不使用
     * @return
     */
    String getResponseJson_Req_getStrangerInfo(String qq, Boolean cache){
        Map<String, Object> paramMap = createParamMap(
                new Object[]{"qq", qq},
                new Object[]{"cache", cache}
        );
        return mapToBeanJson(new Req_getStrangerInfo(), paramMap);
    }

    /**
     * 获取版本？
     * @return 版本？
     */
    String getResponseJson_Req_getVersion(){
        Map<String, Object> paramMap = createParamMap(0);
        return mapToBeanJson(new Req_getVersion(), paramMap);
    }


}
