package com.forte.qqrobot.component.forhttpapi.beans.request.get;


import com.forte.qqrobot.beans.messages.get.GetFriendList;
import com.forte.qqrobot.component.forhttpapi.beans.response.Resp_getFriendList;

/**
 * 「取好友列表」  尚且有异常
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 16:45
 * @since JDK1.8
 **/
public class Req_getFriendList implements GetFriendList, ReqGetBean<Resp_getFriendList> {

    private final String fun = "getFriendList";

    @Override
    public String getFun() {
        return fun;
    }

    @Override
    public Class<Resp_getFriendList> getResponseType() {
        return Resp_getFriendList.class;
    }

    /**
     * 请求的时候都应该有一个参数标识
     */
    @Override
    public String getId() {
        return fun;
    }

}
