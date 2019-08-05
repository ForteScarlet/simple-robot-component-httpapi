package com.forte.qqrobot.component.forhttpapi.beans.response;

import com.forte.qqrobot.beans.messages.result.AbstractGroupMemberList;
import com.forte.qqrobot.beans.messages.result.inner.AbstractGroupMember;
import com.forte.qqrobot.beans.messages.result.inner.GroupMember;
import com.forte.qqrobot.beans.messages.types.PowerType;
import com.forte.qqrobot.beans.messages.types.SexType;

/**
 * @author Ricardo
 * @create 2019-03-22 16:44
 **/

public class Resp_getGroupMemberList extends AbstractGroupMemberList implements RespBean<Resp_getGroupMemberList.GroupMemberList[]> {
    private Integer status;
    private GroupMemberList[] result;
    private String errMsg;

    private String originalData;

    @Override
    public String getOriginalData() {
        return originalData;
    }

    @Override
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

    public void setResult(GroupMemberList[] result) {
        this.result = result;
    }

    @Override
    public GroupMemberList[] getResult() {
        return result == null ? new GroupMemberList[0] : result;
    }

    /**
     * 获取列表, 极度不建议返回为null
     * non-null
     */
    @Override
    public GroupMember[] getList() {
        return result == null ? new GroupMember[0] : result;
    }

    /*
  {
    "status":0,
    "result":[
        {
            "group":12345,
            "qq":67890,
            "name":"le",
            "card":"",
            "gender":255,
            "city":"",
            "joinTime":1501576738,
            "lastTime":1501829899,
            "power":1,
            "tip":"",
            "level":"",
            "inBlackList":0,
            "allowChangeCard":0,
            "tipExpireTime":0,
            "headimg":"http://q.qlogo.cn/headimg_dl?bs=qq&dst_uin=0&spec=100"
        }
    ]
}

result	array	群成员信息
result[i]	object	第i+1个群成员信息
result[i].qq	number	QQ号
result[i].name	string	QQ昵称
result[i].card	string	群名片
result[i].gender	int	性别ID，0/男性，1/女性，255/未知
result[i].city	string	所在城市
result[i].joinTime	int	加群时间，时间戳形式
result[i].lastTime	int	最后发言时间，时间戳形式
result[i].power	int	管理权限，1/成员，2/管理，3/群主
result[i].tip	string	专属头衔
result[i].level	string	群成员等级所对应的等级名称
result[i].card	string	群名片
result[i].inBlackList	int	不良用户，0/不是，1/是
result[i].allowChangeCard	int	允许修改名片，0/不允许，1/允许
result[i].tipExpireTime	int	头衔有效期，时间戳形式，-1为永不到期
result[i].headimg	string	QQ头像
     */
    public static class GroupMemberList extends AbstractGroupMember {
        private String group;
        private String qq;
        private String name;
        private String card;
        private Integer gender;
        private String city;
        private String joinTime;
        private String lastTime;
        private Integer power;
        private String tip;
        private String level;
        private Integer inBlackList;
        private Integer allowChangeCard;
        private Integer tipExpireTime;
        private String headimg;
        private String originalData;

        @Override
        public String getOriginalData() {
            return originalData;
        }

        @Override
        public void setOriginalData(String originalData) {
            this.originalData = originalData;
        }

        @Override
        public void setGroup(String group) {
            this.group = group;
        }

        @Override
        public String getQq() {
            return qq;
        }

        @Override
        public void setQq(String qq) {
            this.qq = qq;
        }

        /**
         * 群号
         */
        @Override
        public String getGroup() {
            return group;
        }

        /**
         * QQ号
         */
        @Override
        public String getQQ() {
            return qq;
        }

        @Override
        public String getName() {
            return name;
        }

        /**
         * 获取群昵称
         */
        @Override
        public String getNickName() {
            return card;
        }

        /**
         * 获取性别
         */
        @Override
        public SexType getSex() {
            return gender == 0 ? SexType.MALE : gender == 1 ? SexType.FEMALE : SexType.UNKNOWN;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        @Override
        public String getCity() {
            return city;
        }

        @Override
        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public Long getJoinTime() {
            return Long.parseLong(joinTime);
        }

        public void setJoinTime(String joinTime) {
            this.joinTime = joinTime;
        }

        @Override
        public Long getLastTime() {
            return Long.parseLong(lastTime);
        }

        public void setLastTime(String lastTime) {
            this.lastTime = lastTime;
        }

        @Override
        public PowerType getPower() {
            return power == 1 ? PowerType.MEMBER : power == 2 ? PowerType.ADMIN : PowerType.OWNER;
        }

        /**
         * 获取专属头衔
         */
        @Override
        public String getExTitle() {
            return tip;
        }

        /**
         * 等级对应名称
         */
        @Override
        public String getLevelName() {
            return level;
        }

        /**
         * 是否为不良用户
         */
        @Override
        public Boolean isBlack() {
            return inBlackList == 1;
        }

        /**
         * 是否允许修改群名片
         */
        @Override
        public Boolean isAllowChangeNick() {
            return allowChangeCard == 1;
        }

        /**
         * 头衔到期时间
         */
        @Override
        public Long getExTitleTime() {
            return tipExpireTime.longValue();
        }

        /**
         * 头像
         */
        @Override
        public String getHeadUrl() {
            return headimg;
        }

        public void setPower(Integer power) {
            this.power = power;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public Integer getInBlackList() {
            return inBlackList;
        }

        public void setInBlackList(Integer inBlackList) {
            this.inBlackList = inBlackList;
        }

        public Integer getAllowChangeCard() {
            return allowChangeCard;
        }

        public void setAllowChangeCard(Integer allowChangeCard) {
            this.allowChangeCard = allowChangeCard;
        }

        public Integer getTipExpireTime() {
            return tipExpireTime;
        }

        public void setTipExpireTime(Integer tipExpireTime) {
            this.tipExpireTime = tipExpireTime;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }
    }

}
