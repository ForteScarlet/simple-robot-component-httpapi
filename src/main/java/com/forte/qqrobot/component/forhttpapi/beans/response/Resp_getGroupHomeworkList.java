package com.forte.qqrobot.component.forhttpapi.beans.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO ※ 本类可能存在一些问题
 * @author Ricardo
 * @create 2019-03-22 16:44
 **/

public class Resp_getGroupHomeworkList implements com.forte.qqrobot.beans.messages.result.GroupHomeworkList, RespBean<Resp_getGroupHomeworkList.GroupHomeworkList[]> {
    private Integer status;
    private GroupHomeworkList[] result;
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

    public void setResult(GroupHomeworkList[] result) {
        this.result = result;
    }

    @Override
    public GroupHomeworkList[] getResult() {
        return result;
    }

    /**
     * 获取列表, 极度不建议返回为null
     * non-null
     */
    @Override
    public GroupHomework[] getList() {
        return result;
    }

    /**
     * 获取原本的数据 originalData
     */
    @Override
    public String getOriginalData() {
        return originalData;
    }

    public void setOriginalData(String originalData) {
        this.originalData = originalData;
    }

    /*
         {
        "status":0,
        "result":[
            {
                "content":{
                    "c":[
                        {
                            "text":"在线习题作业（3题）知识点考查：电荷守恒定律元电荷",
                            "type":"str"
                        }
                    ]
                },
                "course_id":100,
                "course_name":"物理",
                "course_pic":"http://p.qpic.cn/qqconadmin/0/11111111/0",
                "flag":16,
                "hw_id":17139600,
                "hw_title":"物理作业",
                "hw_type":0,
                "icon":"http://p.qpic.cn/qqconadmin/0/1112223131/0",
                "need_feedback":true,
                "pnick_name":"精神病",
                "puin":11223456,
                "status":0,
                "team_id":0,
                "ts_create":1498097800
            }
        ]
    }
            result	array	作业信息列表
            result[i]	object	第i+1个作业信息
            result[i].content	object	该作业的内容信息数组
            result[i].content.c[n].text	string	该作业的内容
            result[i].content.c[n].tpe	string	该作业的内容类型
            result[i].course_id	int	该作业的科目ID
            result[i].course_name	string	该作业的科目名
            result[i].course_pic	string	该作业的科目图片链接
            result[i].hw_id	number	该作业ID
            result[i].hw_title	string	该作业的标题
            result[i].hw_type	int	该作业的类型ID
            result[i].icon	string	该作业的图标链接
            result[i].need_feedback	bool	该作业需要反馈，true/需要，false/不需要
            result[i].pnick_name	string	发布该作业的发布人名片
            result[i].puin	number	发布该作业的发布人QQ
            result[i].status	int	该作业的目前状态
            result[i].team_id	int	该作业属于哪个团队的(根据官方政策，无用)
            result[i].ts_create	int	该作业的创建时间，时间戳形式
                      */
    public static class GroupHomeworkList implements GroupHomework {
        //TODO 该作业的内容信息数组 该作业的内容/该作业的内容类型
        private List<Content> content = new ArrayList<>();

        private Integer course_id;
        private String course_name;
        private String course_pic;
        private String flag;
        private Integer hw_id;
        private String hw_title;
        private Integer hw_type;
        private String icon;
        private Boolean need_feedback;
        private String pnick_name;
        private String puin;
        private Integer status;
        private Integer team_id;
        private Integer ts_create;

        public List<Content> getContent() {
            return content;
        }

        public void setContent(List<Content> content) {
            this.content = content;
        }

        public Integer getCourse_id() {
            return course_id;
        }

        public void setCourse_id(Integer course_id) {
            this.course_id = course_id;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public String getCourse_pic() {
            return course_pic;
        }

        public void setCourse_pic(String course_pic) {
            this.course_pic = course_pic;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public Integer getHw_id() {
            return hw_id;
        }

        public void setHw_id(Integer hw_id) {
            this.hw_id = hw_id;
        }

        public String getHw_title() {
            return hw_title;
        }

        public void setHw_title(String hw_title) {
            this.hw_title = hw_title;
        }

        public Integer getHw_type() {
            return hw_type;
        }

        public void setHw_type(Integer hw_type) {
            this.hw_type = hw_type;
        }

        //**************** 接口实现 ****************//

        /**
         * 作业的内容信息
         *
         * @param key
         */
        @Override
        public Content[] getContents(String key) {
            return content.toArray(new Content[0]);
        }

        /**
         * 科目ID
         */
        @Override
        public String getCourseId() {
            return String.valueOf(course_id);
        }

        /**
         * 科目名称
         */
        @Override
        public String getCourseName() {
            return course_name;
        }

        /**
         * 该作业的科目图片链接
         */
        @Override
        public String getCoursePic() {
            return course_pic;
        }

        /**
         * 该作业ID
         */
        @Override
        public String getId() {
            return String.valueOf(hw_id);
        }

        /**
         * 该作业标题
         */
        @Override
        public String getTitle() {
            return hw_title;
        }

        /**
         * 作业类型ID
         */
        @Override
        public String getType() {
            return String.valueOf(hw_type);
        }

        @Override
        public String getIcon() {
            return icon;
        }

        /**
         * 该作业是否需要反馈
         */
        @Override
        public Boolean isNeedFeedBack() {
            return need_feedback;
        }

        /**
         * 发布人的昵称
         */
        @Override
        public String getAnnoNick() {
            return pnick_name;
        }

        /**
         * 发布人的QQ号
         */
        @Override
        public String getAnnoQQ() {
            return puin;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Boolean getNeed_feedback() {
            return need_feedback;
        }

        public void setNeed_feedback(Boolean need_feedback) {
            this.need_feedback = need_feedback;
        }

        public String getPnick_name() {
            return pnick_name;
        }

        public void setPnick_name(String pnick_name) {
            this.pnick_name = pnick_name;
        }

        public String getPuin() {
            return puin;
        }

        public void setPuin(String puin) {
            this.puin = puin;
        }

        @Override
        public String getStatus() {
            return String.valueOf(status);
        }

        /**
         * 创建时间
         */
        @Override
        public Long getTime() {
            return ts_create.longValue();
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getTeam_id() {
            return team_id;
        }

        public void setTeam_id(Integer team_id) {
            this.team_id = team_id;
        }

        public Integer getTs_create() {
            return ts_create;
        }

        public void setTs_create(Integer ts_create) {
            this.ts_create = ts_create;
        }
    }

    /**
     * 作业内容
     */
    public static class Content implements GroupHomework.Content {

        private String text;
        private String type;

        @Override
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
