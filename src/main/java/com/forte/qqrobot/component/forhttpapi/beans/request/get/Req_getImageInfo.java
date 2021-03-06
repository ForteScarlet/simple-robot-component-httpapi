package com.forte.qqrobot.component.forhttpapi.beans.request.get;


import com.forte.qqrobot.beans.messages.get.GetImageInfo;
import com.forte.qqrobot.beans.messages.result.ImageInfo;
import com.forte.qqrobot.component.forhttpapi.beans.response.Resp_getImageInfo;

/**
 * 「取图片信息」
 *  ※ 只能获取酷Q接收到的图片
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 17:04
 * @since JDK1.8
 **/
public class Req_getImageInfo implements GetImageInfo, ReqGetBean<Resp_getImageInfo> {

    private final String fun = "getImageInfo";

    /** 图片文件名 */
    private String source;
    /** 需要回传文件内容 */
    private Boolean needFile;


    @Override
    public String getFun() {
        return fun;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getNeedFile() {
        return needFile;
    }

    public void setNeedFile(Boolean needFile) {
        this.needFile = needFile;
    }

    @Override
    public Class<Resp_getImageInfo> getResponseType() {
        return Resp_getImageInfo.class;
    }



    /**
     * 请求的时候都应该有一个参数标识
     */
    @Override
    public String getId() {
        return fun;
    }

    @Override
    public String getFlag() {
        return source;
    }
}
