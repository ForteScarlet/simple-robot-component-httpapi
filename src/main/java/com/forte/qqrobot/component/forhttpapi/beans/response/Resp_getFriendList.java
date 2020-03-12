package com.forte.qqrobot.component.forhttpapi.beans.response;

import com.forte.qqrobot.beans.messages.result.AbstractFriendList;
import com.forte.qqrobot.beans.messages.result.inner.AbstractFriend;
import com.forte.qqrobot.beans.messages.result.inner.Friend;

import java.util.*;

/**
 * TODO ※ 本类可能存在一些问题
 * @author Ricardo
 * @create 2019-03-22 16:44
 **/

public class Resp_getFriendList extends AbstractFriendList implements RespBean<Resp_getFriendList.Resp_FriendList[]> {
    private Integer status;
    private Resp_FriendList[] result;
    private String errMsg;
    private Integer errcode;
    private String originalData;

    @Override
    public String toString() {
        return "Resp_getBanList{" +
                "status=" + status +
                ", result=" + getFriendList() +
                ", errMsg='" + errMsg + '\'' +
                ", originalData='" + originalData + '\'' +
                "} " + super.toString();
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

    public void setResult(Resp_FriendList[] result) {
        this.result = result;
    }

    @Override
    public Resp_FriendList[] getResult() {
        return result == null ? new Resp_FriendList[0] : result;
    }

    @Override
    public String getOriginalData() {
        return originalData;
    }

    @Override
    public void setOriginalData(String originalData) {
        this.originalData = originalData;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    /**
     * 各个分组下的好友列表
     */
    @Override
    public Map<String, Friend[]> getFriendList() {
        Map<String, Friend[]> map = new HashMap<>(result.length / 2);
        for (Resp_FriendList fList : result) {
            Resp_Friend[] mems = fList.getMems();
            map.put(fList.getGname(), Arrays.copyOf(mems, mems.length));
        }
        return map;
    }

    /**
     * 通过某个分组获取其中的好友列表
     *
     * @param group
     */
    @Override
    public Resp_Friend[] getFirendList(String group) {
        for (Resp_FriendList friendList : result) {
            if(friendList.getGname().equals(group)){
                Resp_Friend[] mems = friendList.getMems();
                return Arrays.copyOf(mems, mems.length);
            }
        }
        return null;
    }

    /*
          {
        "status":0,
        "result":{
            "1":{
                "gname":"disKnow",
                "mems":[
                    {
                        "name":"BBQ",
                        "uin":99999
                    }
                ]
            },
            "2":{
                "gname":"ther",
                "mems":[
                    {
                        "name":"友人A",
                        "uin":12345
                    }
                ]
            }
        }
    }
             result	array	好友列表数组
             result[i]	array	第i+1个分组信息
             result[i].gname	string	该分组的组名
             result[i].mems	array	该分组的用户列表信息
             result[i].mems[n]	array	该分组的第n+1个用户信息
             result[i].mems[n].name	string	该用户的备注
             result[i].mems[n].uin	number	该用户的QQ号
                      */
    public static class Resp_FriendList {
        private String gname;
        //这里是一个分组下的所有好友
        private Resp_Friend[] mems;

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
        }

        public Resp_Friend[] getMems() {
            return mems;
        }

        public void setMems(Resp_Friend[] mems) {
            this.mems = mems;
        }
    }

    /**
     * 好友对象
     */
    public static class Resp_Friend extends AbstractFriend {

        private String name;

        private String uin;

        private String originalData;

        @Override
        public String getOriginalData() {
            return originalData;
        }

        @Override
        public void setOriginalData(String originalData) {
            this.originalData = originalData;
        }
        /**
         * 获取好友昵称
         */
        @Override
        public String getName() {
            return name;
        }

        /**
         * 获取好友QQ号
         */
        @Override
        public String getQQ() {
            return uin;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        public String getUin() {
            return uin;
        }

        public void setUin(String uin) {
            this.uin = uin;
        }
    }

}
