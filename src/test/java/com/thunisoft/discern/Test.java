package com.thunisoft.discern;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Test {
    //设置APPID/AK/SK
    public static final String APP_ID = "11367111";
    public static final String API_KEY = "vPxiqLmS9ScQTPKL5Uz15ePm";
    public static final String SECRET_KEY = "lmyOMdLFn1VV7IAfkenjyO6yZo0RYYoq ";

    public static void main(String[] args) throws JSONException {
        // 初始化一个AipImageClassifyClient
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        client.setHttpProxy("192.168.71.7", 808);  // 设置http代理
       // client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "C:\\Users\\Public\\Pictures\\文件6.jpg";
        JSONObject res = client.objectDetect(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }


}
