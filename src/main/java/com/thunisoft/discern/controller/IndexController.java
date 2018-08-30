package com.thunisoft.discern.controller;

import com.alibaba.fastjson.JSON;
import com.thunisoft.discern.cst.SysConst;
import com.thunisoft.discern.pojo.Car;
import com.thunisoft.discern.service.AuthService;
import com.thunisoft.discern.utils.HttpUtil;
import com.thunisoft.discern.utils.Image2Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import static com.thunisoft.discern.cst.SysConst.TOKEN;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private AuthService authService;

    @RequestMapping("/receiveImg")
    @ResponseBody
    public String receiveImg(HttpServletRequest request) throws FileNotFoundException, UnsupportedEncodingException {
        String file = request.getParameter("file");
        String auth = authService.getAuth();
        //对图片进行Base64转码
        //  Base64Util.encode()
        String imageStr = Image2Base64Util.getImageStr("C:\\Users\\baiyi\\Desktop\\ocr图库\\2.jpg");
        // 加密
        /*  BASE64Encoder encoder = new BASE64Encoder();*/
        /*  String encode1 = encoder.encode( file.getBytes());*/
        String encode = URLEncoder.encode(imageStr, "UTF-8");
        String url = SysConst.CAR_DISCERN;
        //设置请求参数
        HashMap<String, String> map = new HashMap();
        map.put("access_token", auth);
        map.put("image", encode);

        String params = "access_token" + map.get("access_token") + "&image=" + map.get("image");
        String s = HttpUtil.sendPost(url, "access_token=" + auth + "&image=" + encode);
        System.out.println(s);
        ModelAndView mv = new ModelAndView();
        return null;
    }

    @RequestMapping("/index")
    public String index() {
        return "/demo2";
    }

    @RequestMapping("/getimg")
    @ResponseBody
    public Car getImg(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            // 加密
            BASE64Encoder encoder = new BASE64Encoder();
            String encode1 = encoder.encode(file.getBytes());
            String encode = URLEncoder.encode(encode1, "UTF-8");
            String url = SysConst.CAR_DISCERN;
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

