package com.thunisoft.discern.controller.car;

import com.alibaba.fastjson.JSON;
import com.thunisoft.discern.cst.SysConst;
import com.thunisoft.discern.pojo.Car;
import com.thunisoft.discern.utils.HttpUtil;
import com.thunisoft.discern.utils.Image2Base64Util;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

@Controller
@RequestMapping("/car")
public class CarController {
    @RequestMapping("/index")
    @ResponseBody
    public Object index(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (!file.isEmpty()) {

            if (file.getBytes().length > 2097152) {
                String imgpath="E:\\ocrImg\\"+file.getOriginalFilename();
                Thumbnails.of(file.getInputStream()).scale(1f).outputQuality(0.1f).toFile(imgpath);

                String imageStr = Image2Base64Util.getImageStr(imgpath);
                String encode = URLEncoder.encode(imageStr, "UTF-8");
                String url = SysConst.CAR_DISCERN;
                //设置请求参数
                HashMap<String, String> map = new HashMap();
                map.put("access_token", "24.53c87d96386f8a6a411c731645a0cc40.2592000.1538039297.282335-11367111");
                map.put("image", imageStr);

                String params = "access_token" + map.get("access_token") + "&image=" + map.get("image");
                String s = HttpUtil.sendPost(url, "access_token=" + "24.53c87d96386f8a6a411c731645a0cc40.2592000.1538039297.282335-11367111" + "&image=" + encode);
                Car car = JSON.parseObject(s, Car.class);
                return car;
            }

            // 加密
            BASE64Encoder encoder = new BASE64Encoder();
            String encode1 = encoder.encode(file.getBytes());
            String encode = URLEncoder.encode(encode1, "UTF-8");
            String url = SysConst.CAR_DISCERN;
            //设置请求参数
            HashMap<String, String> map = new HashMap();
//            map.put("access_token", TOKEN);
            map.put("access_token", "24.53c87d96386f8a6a411c731645a0cc40.2592000.1538039297.282335-11367111");
            map.put("image", encode);
            String params = "access_token" + map.get("access_token") + "&image=" + map.get("image");
//            String s = HttpUtil.sendPost(url, "access_token=" + TOKEN + "&image=" + encode);
            String s = HttpUtil.sendPost(url, "access_token=" + "24.53c87d96386f8a6a411c731645a0cc40.2592000.1538039297.282335-11367111" + "&image=" + encode);
            System.out.println(s);
            Car car = JSON.parseObject(s, Car.class);
            return car;
        }
        return null;
    }
}
