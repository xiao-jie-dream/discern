package com.thunisoft.discern.utils;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 百度ocr图片识别
 */
public class OCRUtil {
    //设置APPID/AK/SK
    public static final String APP_ID = "11165292";
    public static final String API_KEY = "l46nQNjiLPNhHwTFXiL9cakV";
    public static final String SECRET_KEY = "Uae18MAA3k44fMNGeLvFCDMDXCgSXRkY";



    public static JSONObject analysisImageByImageURL(String imageURL) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        client.setHttpProxy("192.168.71.7", 808);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //  System.setProperty("aip.log4j.conf", "/log4j.properties");

        // 调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");

        // 参数为本地图片路径

        //   JSONObject res = client.basicGeneral(image, options);
        // System.out.println(res.toString(2));

        // 参数为本地图片路径
        /*String image = "E:\\qisu3.jpg";*/
        JSONObject res = client.basicGeneral(imageURL, options);
        System.out.println(res.toString(2));
        return res;
    }


}
