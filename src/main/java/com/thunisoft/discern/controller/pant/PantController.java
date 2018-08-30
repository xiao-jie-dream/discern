package com.thunisoft.discern.controller.pant;

import com.alibaba.fastjson.JSON;
import com.thunisoft.discern.cst.SysConst;
import com.thunisoft.discern.pojo.Car;
import com.thunisoft.discern.utils.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

import static com.thunisoft.discern.cst.SysConst.TOKEN;

@Controller
@RequestMapping("/pant")
public class PantController {
    @RequestMapping("/index")
    @ResponseBody
    public Object index(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            // 加密
            BASE64Encoder encoder = new BASE64Encoder();
            String encode1 = encoder.encode(file.getBytes());
            String encode = URLEncoder.encode(encode1, "UTF-8");
            String url = SysConst.PANT_DISCERN;
            //设置请求参数
            HashMap<String, String> map = new HashMap();
            map.put("access_token", TOKEN);
            map.put("image", encode);
            String params = "access_token" + map.get("access_token") + "&image=" + map.get("image");
            String s = HttpUtil.sendPost(url, "access_token=" + TOKEN + "&image=" + encode);
            System.out.println(s);
            Car car = JSON.parseObject(s, Car.class);
            return car;
        }
        return null;
    }
}
