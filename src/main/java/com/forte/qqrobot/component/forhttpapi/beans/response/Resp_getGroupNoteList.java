package com.forte.qqrobot.component.forhttpapi.beans.response;

import com.forte.qqrobot.beans.messages.result.AbstractGroupNoteList;
import com.forte.qqrobot.beans.messages.result.GroupNoteList;
import com.forte.qqrobot.beans.messages.result.inner.AbstractGroupNote;
import com.forte.qqrobot.beans.messages.result.inner.GroupNote;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO ※ 可能会有问题
 * @author Ricardo
 * @create 2019-03-22 16:44
 **/

public class Resp_getGroupNoteList extends AbstractGroupNoteList implements RespBean<Resp_getGroupNoteList.GroupNoteList[]> {
    private Integer status;
    private GroupNoteList[] result;
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

    public void setResult(GroupNoteList[] result) {
        this.result = result;
    }

    @Override
    public GroupNoteList[] getResult() {
        return result == null ? new GroupNoteList[0] : result;
    }

    /**
     * 获取列表, 极度不建议返回为null
     * non-null
     */
    @Override
    public GroupNote[] getList() {
        return result == null ? new GroupNote[0] : result;
    }

    /*
 {
    "status":0,
    "result":[
        {
            "cn":0,
            "fid":"890aa71260400",
            "fn":0,
            "msg":{
                "pics":[
                    {
                        "id":"XfzBqF5ggFwRKRSQ05ctWJY7Hc"
                    }
                ],
                "text":"xxx",
                "text_face":"xxxa",
                "title":"领取授权通知"
            },
            "pubt":1492941154,
            "read_num":1,
            "settings":{
                "is_show_edit_card":0
            },
            "type":6,
            "u":67890,
            "vn":0
        }
    ]
}
result	array	公告信息数组
result[i]	object	第i+1个公告信息
result[i].fid	string	公告ID
result[i].msg	object	公告信息数组
result[i].msg.text	string	公告内容(完整)
result[i].msg.text_face	string	公告内容(预览)
result[i].msg.title	string	公告标题
result[i].pubt	int	发布时间戳
result[i].read_num	int	已阅读的人数
result[i].settings	object	公告附带的信息
result[i].settings.is_show_edit_card	int	提醒群成员修改名片，1/提醒，0/不提醒
result[i].type	int	公告类型ID
result[i].u	number	发布人QQ
     */
    public static class GroupNoteList extends AbstractGroupNote {
        private String cn;
        private String fid;
        private String fn;
        // TODO 公告信息数组
        private Map<String, Object> msg = new HashMap<>();
        private String pubt;
        private Integer read_num;
        // TODO 公告附带的信息
        private Map<String, Object> settings = new HashMap<>();
        private Integer type;
        private String u;
        private String vn;
        private String originalData;

        @Override
        public String getOriginalData() {
            return originalData;
        }

        @Override
        public void setOriginalData(String originalData) {
            this.originalData = originalData;
        }
        public String getCn() {
            return cn;
        }

        public void setCn(String cn) {
            this.cn = cn;
        }

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public String getFn() {
            return fn;
        }

        public void setFn(String fn) {
            this.fn = fn;
        }

        /**
         * ID
         */
        @Override
        public String getId() {
            return fid;
        }

        @Override
        public String getMsg() {
            return msg.toString();
        }

        /**
         * 预览文
         */
        @Override
        public String getFaceMsg() {
            return msg.toString();
        }

        /**
         * 标题
         */
        @Override
        public String getTitle() {
            return msg.toString();
        }

        /**
         * 发布时间
         */
        @Override
        public Long getTime() {
            return Long.parseLong(pubt);
        }

        /**
         * 已读人数数量
         */
        @Override
        public Integer getReadNum() {
            return read_num;
        }

        /**
         * 是否提醒群员修改群名片
         */
        @Override
        public Boolean isShowEditCard() {
            return Integer.parseInt(settings.get("is_show_edit_card")+"") == 1;
        }

        /**
         * 发布者QQ
         */
        @Override
        public String getQQ() {
            return u;
        }

        /**
         * 公告类型ID
         */
        @Override
        public String getTypeId() {
            return String.valueOf(type);
        }

        public void setMsg(Map<String, Object> msg) {
            this.msg = msg;
        }

        public String getPubt() {
            return pubt;
        }

        public void setPubt(String pubt) {
            this.pubt = pubt;
        }

        public Integer getRead_num() {
            return read_num;
        }

        public void setRead_num(Integer read_num) {
            this.read_num = read_num;
        }

        public Map<String, Object> getSettings() {
            return settings;
        }

        public void setSettings(Map<String, Object> settings) {
            this.settings = settings;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getU() {
            return u;
        }

        public void setU(String u) {
            this.u = u;
        }

        public String getVn() {
            return vn;
        }

        public void setVn(String vn) {
            this.vn = vn;
        }



    }

}
