package com.forte.qqrobot.component.forhttpapi.beans.response;

import com.forte.qqrobot.beans.messages.result.AbstractGroupTopNote;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ricardo
 * @create 2019-03-22 16:44
 **/

public class Resp_getGroupTopNote extends AbstractGroupTopNote implements RespBean<Resp_getGroupTopNote.GroupTopNote> {
    private Integer status;
    private GroupTopNote result;
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

    public void setResult(GroupTopNote result) {
        this.result = result;
    }

    @Override
    public GroupTopNote getResult() {
        return result;
    }

    /**
     * ID
     */
    @Override
    public String getId() {
        return result == null ? null : result.getFid();
    }

    /**
     * 完整正文
     */
    @Override
    public String getMsg() {
        return result == null || result.getMsg() == null ? null : result.getMsg().toString();
    }

    /**
     * 预览文
     */
    @Override
    public String getFaceMsg() {
        return result == null ? null : result.getMsg().toString();
    }

    /**
     * 标题
     */
    @Override
    public String getTitle() {
        return result == null ? null : result.getMsg().toString();
    }

    /**
     * 发布时间
     */
    @Override
    public Long getTime() {
        return Long.parseLong(result.getPubt());
    }

    /**
     * 已读人数数量
     */
    @Override
    public Integer getReadNum() {
        return result == null ? null : result.getRead_num();
    }

    /**
     * 是否提醒群员修改群名片
     * 似乎是不支持的API
     */
    @Override
    @Deprecated
    public Boolean isShowEditCard() {
        return false;
    }

    /**
     * 发布者QQ
     */
    @Override
    public String getQQ() {
        return result == null ? null : result.getU();
    }

    /**
     * 公告类型ID
     */
    @Override
    public String getTypeId() {
        return String.valueOf(result.getType());
    }

    /*
{
    "status":0,
    "result":{
        "cn":0,
        "fid":"890aa71bc9b5784da0e00",
        "fn":0,
        "msg":{
            "text":"",
            "text_face":"",
            "title":"本群须知"
        },
        "pubt":1469779056,
        "read_num":1,
        "settings":{
            "is_show_edit_card":0
        },
        "type":20,
        "u":10000,
        "vn":0
    }
}
result	object	公告信息数组
result.fid	string	公告ID
result.msg	object	公告信息数组
result.msg.text	string	公告内容(完整)
result.msg.text_face	string	公告内容(预览)
result.msg.title	string	公告标题
result.pubt	int	发布时间戳
result.read_num	int	已阅读的人数
result.settings	object	公告附带的信息
result.settings.is_show_edit_card	int	提醒群成员修改名片，1/提醒，0/不提醒
result.type	int	公告类型ID
result.u	number	发布人QQ
     */
    public static class GroupTopNote {
        private String cn;
        private String fid;
        private String fn;
        // TODO 公告信息数组
        private List<Map<String, Object>> msg = new ArrayList<>();
        private String pubt;
        private Integer read_num;
        // TODO 公告附带的信息
        private List<Map<String, Object>> settings = new ArrayList<>();
        private Integer type;
        private String u;
        private String vn;

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

        public List<Map<String, Object>> getMsg() {
            return msg;
        }

        public void setMsg(List<Map<String, Object>> msg) {
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

        public List<Map<String, Object>> getSettings() {
            return settings;
        }

        public void setSettings(List<Map<String, Object>> settings) {
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
