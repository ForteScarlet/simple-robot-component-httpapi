package com.forte.qqrobot.component.forhttpapi.beans.response;

/**
 * @author Ricardo
 * @create 2019-03-22 16:44
 **/

public class Resp_getImageInfo implements com.forte.qqrobot.beans.messages.result.ImageInfo,  RespBean<Resp_getImageInfo.ImageInfo> {
    private Integer status;
    private ImageInfo result;
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

    public void setResult(ImageInfo result) {
        this.result = result;
    }

    @Override
    public ImageInfo getResult() {
        return result;
    }

    /**
     * 取图片的MD5值
     */
    @Override
    public String getMD5() {
        return result.getMd5();
    }

    /**
     * 图片宽
     */
    @Override
    public Double getWidth() {
        return result.getWidth();
    }

    /**
     * 图片长
     */
    @Override
    public Double getHeight() {
        return result.getHeight();
    }

    /**
     * 获取图片大小 字节
     */
    @Override
    public Long getSize() {
        return result.getSize();
    }

    /**
     * 图片路径
     */
    @Override
    public String getUrl() {
        return result.getUrl();
    }

    /**
     * 图片上传到腾讯时候的时间
     */
    @Override
    public Long getTime() {
        return Long.parseLong(result.getAddTime());
    }

    /**
     * 图片Base64编码内容
     */
    @Override
    public String getFileBase64() {
        return result.getFile();
    }


    /*
{
    "status":0,
    "result":{
        "md5":"3FFB03403A91DF",
        "width":70,
        "height":54,
        "size":1656,
        "url":"http://gchat.qpic.cn/",
        "addTime":1502951368,
        "file":"/9j/4QCcRXhpZgAASUkBAAAANgif//Z"
    }
}
result	object	图片信息
result.md5	string	图片的MD5值
result.width	int	图片宽度
result.height	string	图片高度
result.size	int	图片文件大小，单位：字节(B)
result.url	string	图片的url地址，请注意QQ有防盗链机制，不能直接引用
result.addTime	int	图片上传到腾讯服务器的时间，时间戳形式
result.file	string	图片文件内容，已Base64编码
     */
    public static class ImageInfo {
        private String md5;
        private Double width;
        private Double height;
        private Long size;
        private String url;
        private String addTime;
        private String file;

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public Double getWidth() {
            return width;
        }

        public void setWidth(Double width) {
            this.width = width;
        }

        public Double getHeight() {
            return height;
        }

        public void setHeight(Double height) {
            this.height = height;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }
    }

}
