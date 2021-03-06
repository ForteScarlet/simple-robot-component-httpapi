package com.forte.qqrobot.component.forhttpapi.beans.request.get;


import com.forte.qqrobot.beans.messages.get.GetGroupList;
import com.forte.qqrobot.component.forhttpapi.beans.response.Resp_getGroupList;

/**
 * 「取群列表」 有异常
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 16:55
 * @since JDK1.8
 **/
public class Req_getGroupList implements GetGroupList, ReqGetBean<Resp_getGroupList> {

    private final String fun = "getGroupList";

    @Override
    public String getFun() {
        return fun;
    }

    @Override
    public Class<Resp_getGroupList> getResponseType() {
        return Resp_getGroupList.class;
    }

    /**
     * 请求的时候都应该有一个参数标识
     */
    @Override
    public String getId() {
        return fun;
    }

}
