package com.forte.qqrobot.component.forhttpapi.beans.response;

import com.forte.qqrobot.beans.messages.result.FriendList;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO ※ 本类可能存在一些问题
 * @author Ricardo
 * @create 2019-03-22 16:44
 **/

public class Resp_getFriendList implements FriendList,  RespBean<Resp_getFriendList.FriendList[]> {
    private Integer status;
    private FriendList[] result;
    private String errMsg;
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

    public void setResult(FriendList[] result) {
        this.result = result;
    }

    @Override
    public FriendList[] getResult() {
        return result;
    }

    @Override
    public String getOriginalData() {
        return originalData;
    }

    public void setOriginalData(String originalData) {
        this.originalData = originalData;
    }

    /**
     * 各个分组下的好友列表
     */
    @Override
    public Map<String, com.forte.qqrobot.beans.messages.result.inner.Friend[]> getFriendList() {
        Map<String, List<List<Friend>>> collect = Arrays.stream(result).collect(Collectors.groupingBy(FriendList::getGname, Collectors.mapping(FriendList::getMems, Collectors.toList())));
        return collect.entrySet().stream().map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue().toArray(new Friend[0]))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * 通过某个分组获取其中的好友列表
     *
     * @param group
     */
    @Override
    public Friend[] getFirendList(String group) {
        for (FriendList friendList : result) {
            if(friendList.getGname().equals(group)){
                return friendList.getMems().toArray(new Friend[0]);
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
    public static class FriendList {
        private String gname;
        //这里是一个分组下的所有好友
        private List<Friend> mems = new ArrayList<>();

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
        }

        public List<Friend> getMems() {
            return mems;
        }

        public void setMems(List<Friend> mems) {
            this.mems = mems;
        }
    }

    /**
     * 好友对象
     */
    public static class Friend implements com.forte.qqrobot.beans.messages.result.inner.Friend {

        private String name;

        private String uin;

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
