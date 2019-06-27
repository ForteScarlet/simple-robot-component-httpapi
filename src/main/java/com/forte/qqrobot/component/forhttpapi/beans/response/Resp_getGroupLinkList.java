package com.forte.qqrobot.component.forhttpapi.beans.response;

import com.forte.qqrobot.beans.messages.result.GroupLinkList;
import com.forte.qqrobot.beans.messages.result.inner.GroupLink;

/**
 * @author Ricardo
 * @create 2019-03-22 16:44
 **/

public class Resp_getGroupLinkList implements GroupLinkList, RespBean<Resp_getGroupLinkList.GroupLinkList[]> {
    private Integer status;
    private GroupLinkList[] result;
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

    public void setResult(GroupLinkList[] result) {
        this.result = result;
    }

    @Override
    public GroupLinkList[] getResult() {
        return result == null ? new GroupLinkList[0] : result;
    }

    /**
     * 获取列表, 极度不建议返回为null
     * non-null
     */
    @Override
    public GroupLink[] getList() {
        return result == null ? new GroupLink[0] : result;
    }

    /*
    {
    "status":0,
    "result":[
        {
            "raw_url":"https://www.appnode.com/?0ja3cp",
            "seq":243,
            "thumbnail":"https://www.appnode.com/images/logo-s.gif",
            "time":1502607100,
            "title":"正在加载活动页面...",
            "uin":12345
        }
    ]
}
            result	array	链接信息列表
            result[i]	object	第i+1个链接信息
            result[i].raw_url	string	该链接发出来时的url
            result[i].thumbnail	string	该链接的站点图片
            result[i].time	int	该链接发布时间，时间戳形式
            result[i].title	string	该链接的简要内容
            result[i].uin	number	发布该链接的QQ

     */
    public static class GroupLinkList implements GroupLink {
        private String raw_url;
        private String seq;
        private String thumbnail;
        private String time;
        private String title;
        private String uin;
        private String originalData;

        @Override
        public String getOriginalData() {
            return originalData;
        }

        public void setOriginalData(String originalData) {
            this.originalData = originalData;
        }
        public String getRaw_url() {
            return raw_url;
        }

        public void setRaw_url(String raw_url) {
            this.raw_url = raw_url;
        }

        public String getSeq() {
            return seq;
        }

        public void setSeq(String seq) {
            this.seq = seq;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        /**
         * 链接地址
         */
        @Override
        public String getUrl() {
            return raw_url;
        }

        /**
         * 链接的封面地址
         */
        @Override
        public String getPicUrl() {
            return null;
        }

        @Override
        public Long getTime() {
            return Long.parseLong(time);
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String getTitle() {
            return title;
        }

        /**
         * 该连接的发布者QQ
         */
        @Override
        public String getQQ() {
            return null;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUin() {
            return uin;
        }

        public void setUin(String uin) {
            this.uin = uin;
        }
    }

}
