package org.jeecg.modules.demo.billsfood.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;

public class FileToJson {

    public static JSONObject fileToJson(String URI) {
        JSONObject json = null;
        try (
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(URI);
        ) {
            json = JSONObject.parseObject(IOUtils.toString(is, "utf-8"));
        } catch (Exception e) {
            System.out.println(URI + "文件读取异常" + e);
        }
        return json;
    }
}
