package com.forte.qqrobot.component.forhttpapi.beans.request.get;


import com.forte.qqrobot.beans.messages.get.GetGroupTopNote;
import com.forte.qqrobot.component.forhttpapi.beans.response.Resp_getGroupTopNote;

/**
 * 「取群置顶公告」
 *
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 17:03
 * @since JDK1.8
 **/
public class Req_getGroupTopNote implements GetGroupTopNote, ReqGetBean<Resp_getGroupTopNote> {

    private final String fun = "getGroupTopNote";
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
    public Class<Resp_getGroupTopNote> getResponseType() {
        return Resp_getGroupTopNote.class;
    }

    /**
     * 请求的时候都应该有一个参数标识
     */
    @Override
    public String getId() {
        return fun;
    }

}
