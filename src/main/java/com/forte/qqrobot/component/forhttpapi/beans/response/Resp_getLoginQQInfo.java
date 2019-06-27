package com.forte.qqrobot.component.forhttpapi.beans.response;

/**
 * @author Ricardo
 * @create 2019-03-22 16:44
 **/

public class Resp_getLoginQQInfo implements com.forte.qqrobot.beans.messages.result.LoginQQInfo, RespBean<Resp_getLoginQQInfo.LoginQQInfo> {
    private Integer status;
    private LoginQQInfo result;
    private String errMsg;
    private String originalData;

    @Override
    public String getOriginalData() {
        return originalData;
    }

    public void setOriginalData(String originalData) {
        this.originalData = originalData;
    }



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

    public void setResult(LoginQQInfo result) {
        this.result = result;
    }

    @Override
    public LoginQQInfo getResult() {
        return result;
    }

    /**
     * 昵称
     */
    @Override
    public String getName() {
        return result == null ? null : result.getNick();
    }

    /**
     * QQ号
     */
    @Override
    public String getQQ() {
        return result == null ? null : result.getQq();
    }

    /**
     * 头像地址
     */
    @Override
    public String getHeadUrl() {
        return result == null ? null : result.getHeadimg();
    }

    /**
     * 等级
     */
    @Override
    public Integer getLevel() {
        return result == null ? null : result.getLevel();
    }

    /*
{
    "status":0,
    "result":{
        "nick":"萌萌",
        "qq":105005,
        "headimg":"http://q2.qlogo.cn/g?b=qq&k=JicnmIibic0Ku3MQx2lEvRibRQ&s=100&t=1483373010",
        "level":41
    }
}
result	object	QQ信息
result.nick	string	QQ昵称
result.qq	number	QQ号
result.headimg	string	头像链接
result.level	int	QQ等级
     */
    public static class LoginQQInfo {
        //此类赋予默认值，防止在配置类中获取时出现空指针异常
        private String nick = "";
        private String qq = "";
        private String headimg = "";
        private Integer level = -1;

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }
    }

}
