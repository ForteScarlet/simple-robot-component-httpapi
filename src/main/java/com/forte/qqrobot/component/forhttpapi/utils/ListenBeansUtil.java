package com.forte.qqrobot.component.forhttpapi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.forte.qqrobot.beans.messages.msgget.MsgGet;
import com.forte.qqrobot.component.forhttpapi.beans.response.msgget.HttpMsgGetType;

/**
 * 将字符串转化为对应的消息封装类的工具类
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class ListenBeansUtil {

    /**
     * 将json字符串转化为MsgGet对象
     * @param str json字符串
     */
    public static MsgGet jsonToMsgGet(String str){
        JSONObject jsonData = JSON.parseObject(str);
        jsonData.put("originalData", str);

        Integer type = jsonData.getInteger("type");
        HttpMsgGetType byType = (type == null) ? null : HttpMsgGetType.getByType(type);
        if(byType != null){
            return jsonData.toJavaObject(byType.getType());
        }else{
            return null;
        }
    }


}
