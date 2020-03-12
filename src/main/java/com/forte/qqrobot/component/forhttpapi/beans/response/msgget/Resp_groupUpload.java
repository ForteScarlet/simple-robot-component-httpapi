package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.msgget.AbstractGroupFileUpload;
import com.forte.qqrobot.beans.messages.msgget.GroupFileUpload;
import com.forte.qqrobot.beans.messages.result.AbstractFileInfo;
import com.forte.qqrobot.beans.messages.result.FileInfo;

import java.time.Instant;

/**
 * 群文件上传
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Resp_groupUpload extends BaseMsgGet implements GroupFileUpload {


    /** qq号 */
    private String qq;
    /** 群号 */
    private String group;
    /** 无用的文件信息 */
    private String file;
    /** 文件信息封装类 */
    private FileInfo fileInfo;


    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String getGroup() {
        return group;
    }

    /**
     * 发信人QQ
     */
    @Override
    public String getQQ() {
        return qq;
    }

    /**
     * 文件名
     */
    @Override
    public String getFileName() {
        return fileInfo.getFileName();
    }

    /**
     * 文件大小 Long类型，字节
     */
    @Override
    public Long getFileSize() {
        return fileInfo.getFileSize();
    }

    /**
     * 获取文件Busid
     */
    @Override
    public String getFileBusid() {
        return fileInfo.getBusid();
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    /**
     * 获取ID，如果没有此参数推荐使用UUID等来代替
     */
    @Override
    public String getId() {
        return fileInfo.getId();
    }


    /** 群文件上传的文件信息
     *  内部类
     * */
    public static class FileInfo extends BaseMsgGet implements com.forte.qqrobot.beans.messages.result.FileInfo {

        /** size */
        private Long size;
        /** busid */
        private String busid;
        /** 名称 */
        private String name;
        /** id */
        private String id;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public String getBusid() {
            return busid;
        }

        /**
         * 获取文件大小-字节
         */
        @Override
        public Long getFileSize() {
            return size;
        }

        public void setBusid(String busid) {
            this.busid = busid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        /**
         * 获取文件名称
         */
        @Override
        public String getFileName() {
            return name;
        }

        @Override
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }




    }
}
