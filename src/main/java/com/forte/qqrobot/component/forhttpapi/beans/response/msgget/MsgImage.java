package com.forte.qqrobot.component.forhttpapi.beans.response.msgget;

import com.forte.qqrobot.beans.messages.result.AbstractImageInfo;

/**
 * 根据插件API，如果消息种存在图片信息，则会增加两种参数。
 * 这两个参数其中的‘imageInfo’通过此类进行封装
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class MsgImage extends AbstractImageInfo {
/*
            "md5":"930C95C555552FE8BB4",
            "width":629,
            "height":523,
            "size":23472,
            "url":"https://gchat.qpic.cn",
            "addTime":1503650169
 */

    /** 图片的md5值 */
    private String md5;
    /** 图片的宽度 */
    private Double width;
    /** 图片的高度 */
    private Double height;
    /** 图片的大小，单位：B */
    private Long size;
    /** 图片的下载地址 */
    private String url;
    /** 图片的上传时间，时间戳形式 */
    private Long addTime;


    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public Double getWidth() {
        return width;
    }

    @Override
    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public Double getHeight() {
        return height;
    }

    @Override
    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public Long getSize() {
        return size;
    }

    @Override
    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }
}
