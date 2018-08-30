package com.thunisoft.discern.controller.animal;

import com.alibaba.fastjson.JSON;
import com.thunisoft.discern.cst.SysConst;
import com.thunisoft.discern.pojo.Animal;
import com.thunisoft.discern.pojo.Car;
import com.thunisoft.discern.utils.HttpUtil;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

import static com.thunisoft.discern.cst.SysConst.TOKEN;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    @RequestMapping("/index")
    @ResponseBody
    public Object index(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            // 加密
            BASE64Encoder encoder = new BASE64Encoder();
            String encode1 = encoder.encode(file.getBytes());
            String encode = URLEncoder.encode(encode1, "UTF-8");
            String url = SysConst.ANIMAL_DISCERN;


            //设置请求参数
            HashMap<String, String> map = new HashMap();
//            map.put("access_token",  TOKEN) ;
            map.put("access_token",  "24.53c87d96386f8a6a411c731645a0cc40.2592000.1538039297.282335-11367111") ;
            map.put("image", encode);
            String params = "access_token" + map.get("access_token") + "&image=" + map.get("image");
            String s = HttpUtil.sendPost(url, "access_token=" + "24.53c87d96386f8a6a411c731645a0cc40.2592000.1538039297.282335-11367111" + "&image=" + encode+"&baike_num="+"1");
           // String s = HttpUtil.sendPost(url, "access_token=" + TOKEN + "&image=" + encode+"&baike_num="+"1");
            System.out.println(s);
            Animal animal = JSON.parseObject(s, Animal.class);
            return animal;
        }
        return null;
    }
}
