package com.forte.qqrobot.component.forhttpapi.beans.request.get;


import com.forte.qqrobot.beans.messages.get.GetGroupLinkList;
import com.forte.qqrobot.component.forhttpapi.beans.response.Resp_getGroupLinkList;

/**
 * 「取群链接列表」
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 16:53
 * @since JDK1.8
 **/
public class Req_getGroupLinkList implements GetGroupLinkList, ReqGetBean<Resp_getGroupLinkList> {

    private final String fun = "getGroupLinkList";

    /** 群号 */
    private String group;
    /** 取出数量 */
    private Integer number;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public Class<Resp_getGroupLinkList> getResponseType() {
        return Resp_getGroupLinkList.class;
    }

    /**
     * 请求的时候都应该有一个参数标识
     */
    @Override
    public String getId() {
        return fun;
    }

}
