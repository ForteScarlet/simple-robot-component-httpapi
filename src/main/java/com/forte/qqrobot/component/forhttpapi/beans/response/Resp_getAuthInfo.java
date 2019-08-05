package com.forte.qqrobot.component.forhttpapi.beans.response;

import com.forte.qqrobot.beans.messages.result.AbstractAuthInfo;

/**
 * 「取权限信息」
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 15:41
 * @since JDK1.8
 **/
public class Resp_getAuthInfo extends AbstractAuthInfo implements RespBean<Resp_getAuthInfo.AuthInfo> {

    private Integer status;
    private AuthInfo result;
    private String errMsg;
    /** 原生数据 */
    private String originalData;


    @Override
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public AuthInfo getResult() {
        return result;
    }

    public void setResult(AuthInfo result) {
        this.result = result;
    }

    /**
     * 获取一个编码
     */
    @Override
    public String getCode() {
        return result == null ? null : result.getAuthCode()+"";
    }

    /**
     * 获取cookies信息
     */
    @Override
    public String getCookies() {
        return result == null ? null : result.getCookies();
    }

    /**
     * 获取CsrfToken
     */
    @Override
    public String getCsrfToken() {
        return result == null ? null : result.getCsrfToken()+"";
    }

    /**
     * 获取原本的数据 originalData
     */
    @Override
    public String getOriginalData() {
        return this.originalData;
    }

    @Override
    public void setOriginalData(String originalData) {
        this.originalData = originalData;
    }

    /**
     * ——————————内部类
     */
    public static class AuthInfo{
        /*
       authCode	    int	AuthCode，似乎没什么用
       cookies	    string	Cookies
       csrfToken	number	CsrfToken，即QQ网页用到的 bkn/g_tk等
         */
        private Integer authCode;
        private String cookies;
        private Integer csrfToken;


        public Integer getAuthCode() {
            return authCode;
        }

        public void setAuthCode(Integer authCode) {
            this.authCode = authCode;
        }

        public String getCookies() {
            return cookies;
        }

        public void setCookies(String cookies) {
            this.cookies = cookies;
        }

        public Integer getCsrfToken() {
            return csrfToken;
        }

        public void setCsrfToken(Integer csrfToken) {
            this.csrfToken = csrfToken;
        }
    }
}
