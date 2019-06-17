package com.forte.qqrobot.component.forhttpapi.beans.request.get;


import com.forte.qqrobot.beans.messages.get.GetAuthInfo;
import com.forte.qqrobot.component.forhttpapi.beans.response.Resp_getAuthInfo;

/**
 * 「取权限信息」
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 15:31
 * @since JDK1.8
 **/
public class Req_getAuthInfo implements GetAuthInfo, ReqGetBean<Resp_getAuthInfo> {
    /*
    {
    "fun":"getAuthInfo"
}
     */

    private final String fun = "getAuthInfo";

    @Override
    public String getFun() {
        return fun;
    }

    @Override
    public Class<Resp_getAuthInfo> getResponseType() {
        return Resp_getAuthInfo.class;
    }

    /**
     * 请求的时候都应该有一个参数标识
     */
    @Override
    public String getId() {
        return fun;
    }

}
