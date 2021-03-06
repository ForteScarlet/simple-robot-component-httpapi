package com.forte.qqrobot.component.forhttpapi.beans.request.get;


import com.forte.qqrobot.beans.messages.get.GetGroupInfo;
import com.forte.qqrobot.component.forhttpapi.beans.response.Resp_getGroupInfo;

/**
 * 「取群详细信息」
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 16:52
 * @since JDK1.8
 **/
public class Req_getGroupInfo implements GetGroupInfo, ReqGetBean<Resp_getGroupInfo> {

    private final String fun = "getGroupInfo";
    /** 群号 */
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
    public Class<Resp_getGroupInfo> getResponseType() {
        return Resp_getGroupInfo.class;
    }

    /**
     * 请求的时候都应该有一个参数标识
     */
    @Override
    public String getId() {
        return fun;
    }

}
