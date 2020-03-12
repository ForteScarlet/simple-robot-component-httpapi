package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

/**
 * 提供基础数据字段
 * @author <a href="https://github.com/ForteScarlet"> ForteScarlet </a>
 */
public class BaseMsgGet {

    /** 原始数据 */
    private String originalData;
    /** 没有时间参数，通过程序获取 */
    private Long time;

    private Integer type;
    private Integer subType;

    /**
     * 当前登录的QQ
     */
    private String loginQQ;

    public String getOriginalData() {
        return originalData;
    }

    public void setOriginalData(String originalData) {
        this.originalData = originalData;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getBigType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public String getLoginQQ() {
        return loginQQ;
    }

    public void setLoginQQ(String loginQQ) {
        this.loginQQ = loginQQ;
    }

    public String getThisCode() {
        return getLoginQQ();
    }

    public void setThisCode(String code) {
        setLoginQQ(code);
    }
}
