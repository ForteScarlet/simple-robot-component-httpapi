package com.forte.qqrobot.component.forhttpapi.beans.request.get;


import com.forte.qqrobot.beans.messages.get.GetGroupMemberList;
import com.forte.qqrobot.component.forhttpapi.beans.response.Resp_getGroupMemberList;

/**
 * 「取群成员列表」
 *
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 16:57
 * @since JDK1.8
 **/
public class Req_getGroupMemberList implements GetGroupMemberList, ReqGetBean<Resp_getGroupMemberList> {

    private final String fun = "getGroupMemberList";
    /**
     * 群号
     */
    private String group;

    @Override
    public String getFun() {
        return fun;
    }

    @Override
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public Class<Resp_getGroupMemberList> getResponseType() {
        return Resp_getGroupMemberList.class;
    }

    /**
     * 请求的时候都应该有一个参数标识
     */
    @Override
    public String getId() {
        return fun;
    }


}
