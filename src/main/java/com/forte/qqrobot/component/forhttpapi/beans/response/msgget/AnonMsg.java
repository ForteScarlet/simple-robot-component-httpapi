package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

/**
 * 有时候，私信消息中可能会存在匿名消息
 * 当存在匿名消息的时候，使用此封装类
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class AnonMsg {
    /*
     "anonymousInfo":{
        "aid":1000013,
        "code":"曹植",
        "token":"S4EyN0c8/DX3g=="
    }
     */
    /** 匿名用户标识 */
    private String aid;
    /** 匿名名称 */
    private String code;
    /** 匿名用户Token，已Base64编码 */
    private String token;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
