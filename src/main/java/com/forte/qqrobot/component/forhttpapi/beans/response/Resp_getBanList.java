package com.forte.qqrobot.component.forhttpapi.beans.response;

import com.forte.qqrobot.beans.messages.result.inner.BanInfo;

/**
 * 禁言列表
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 15:46
 * @since JDK1.8
 **/
public class Resp_getBanList implements com.forte.qqrobot.beans.messages.result.BanList, RespBean<Resp_getBanList.BanList[]> {

    private Integer status;
    private BanList[] result;
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
    public BanList[] getResult() {
        return result;
    }

    public void setResult(BanList[] result) {
        this.result = result;
    }

    /**
     * 获取列表, 极度不建议返回为null
     * non-null
     */
    @Override
    public BanInfo[] getList() {
        return result;
    }

    /**
     * 获取原本的数据 originalData
     */
    @Override
    public String getOriginalData() {
        return this.originalData;
    }

    public void setOriginalData(String originalData) {
        this.originalData = originalData;
    }

    /**
     * ——————————内部类
     */
    public static class BanList implements BanInfo {
        /*
            manager	int	该成员是否为管理，此字段固定为1；当成员非管理时，此字段不存在
            nick	string	该成员的群名片
            t	int	该成员离解禁的剩余时间，单位：秒
            uin	number	该成员的QQ号
         */
        private Integer manager;
        private String nick;
        private Integer t;
        private String uin;
        private String originalData;

        @Override
        public String getOriginalData() {
            return originalData;
        }

        public void setOriginalData(String originalData) {
            this.originalData = originalData;
        }

        public Integer getManager() {
            return manager;
        }

        public void setManager(Integer manager) {
            this.manager = manager;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public Integer getT() {
            return t;
        }

        public void setT(Integer t) {
            this.t = t;
        }

        public String getUin() {
            return uin;
        }

        public void setUin(String uin) {
            this.uin = uin;
        }

        /**
         * 被禁言者的QQ
         */
        @Override
        public String getQQ() {
            return uin;
        }

        /**
         * 被禁言成员昵称
         */
        @Override
        public String getNickName() {
            return nick;
        }

        /**
         * 是否为管理员
         */
        @Override
        public Boolean isManager() {
            return manager != null;
        }

        /**
         * 禁言剩余时间
         */
        @Override
        public Long lastTime() {
            return t.longValue();
        }
    }

}
