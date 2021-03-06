package com.forte.qqrobot.component.forhttpapi.beans.request.get;


import com.forte.qqrobot.beans.messages.get.GetStrangerInfo;
import com.forte.qqrobot.component.forhttpapi.beans.response.Resp_getStrangerInfo;

/**
 * 「取陌生人信息」
 * 需要权限131
 * 可能需要权限20
 *
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 17:19
 * @since JDK1.8
 **/
public class Req_getStrangerInfo implements GetStrangerInfo, ReqGetBean<Resp_getStrangerInfo> {

    private final String fun = "getStrangerInfo";

    /**
     * QQ号
     */
    private String qq;

    /**
     * 使用缓存，true/使用，false/不使用
     */
    private Boolean cache;

    @Override
    public String getFun() {
        return fun;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Boolean getCache() {
        return cache;
    }

    public void setCache(Boolean cache) {
        this.cache = cache;
    }

    @Override
    public Class<Resp_getStrangerInfo> getResponseType() {
        return Resp_getStrangerInfo.class;
    }

    /**
     * 请求的时候都应该有一个参数标识
     */
    @Override
    public String getId() {
        return fun;
    }

    @Override
    public String getQQ() {
        return qq;
    }
}
