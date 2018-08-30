package com.thunisoft.discern.controller;

import com.thunisoft.discern.cst.SysConst;
import com.thunisoft.discern.service.AuthService;
import com.thunisoft.discern.utils.HttpUtil;
import com.thunisoft.discern.utils.Image2Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

@Controller
@RequestMapping("/get")
public class DemoController {
    @Autowired
    private AuthService authService;

    @RequestMapping("/getdemo")
    public Object demo() throws IOException {
        String auth = authService.getAuth();
        //对图片进行Base64转码
        //  Base64Util.encode()
        String imageStr = Image2Base64Util.getImageStr("C:\\Users\\baiyi\\Desktop\\ocr图库\\2.jpg");
        String encode = URLEncoder.encode(imageStr, "UTF-8");
        String url = SysConst.CAR_DISCERN;
        //设置请求参数
        HashMap<String, String> map = new HashMap();
        map.put("access_token", auth);
        map.put("image", imageStr);

        String params = "access_token" + map.get("access_token") + "&image=" + map.get("image");
        String s = HttpUtil.sendPost(url, "access_token=" + auth + "&image=" + encode);
        System.out.println(s);
        return s;
    }



}
