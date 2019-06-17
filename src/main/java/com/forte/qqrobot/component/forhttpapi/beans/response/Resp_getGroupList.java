package com.forte.qqrobot.component.forhttpapi.beans.response;

import com.forte.qqrobot.beans.messages.result.GroupList;

/**
 * @author Ricardo
 * @create 2019-03-22 16:44
 **/

public class Resp_getGroupList implements GroupList, RespBean<Resp_getGroupList.getGroupList[]> {
    private Integer status;
    private getGroupList[] result;
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

    public void setResult(getGroupList[] result) {
        this.result = result;
    }

    @Override
    public getGroupList[] getResult() {
        return result;
    }

    /**
     * 获取列表, 极度不建议返回为null
     * non-null
     */
    @Override
    public Group[] getList() {
        return result;
    }


    /*
    *    "status":0,
    "result":[
        {
            "name":"Zero",
            "group":4639,
            "headimg":"http://p.qlogo.cn/gh/4639/4639/100"
        }
    ]
}

result	array	群信息列表
result[i]	object	第i+1个群信息
result[i].name	string	群名，url编码
result[i].group	number	群号
result[i].headimg	string	群头像链接
     */
    public static class getGroupList implements Group {
        private String name;
        private String group;
        private String headimg;

        @Override
        public String getName() {
            return name;
        }

        /**
         * 群号
         */
        @Override
        public String getCode() {
            return group;
        }

        /**
         * 群头像地址
         */
        @Override
        public String getHeadUrl() {
            return headimg;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }
    }

}
