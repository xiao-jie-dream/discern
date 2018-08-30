package com.thunisoft.discern.cst;

import com.thunisoft.discern.service.AuthService;

public class SysConst {

    public final static String PANT_DISCERN = "https://aip.baidubce.com/rest/2.0/image-classify/v1/plant";//植物
    public final static String CAR_DISCERN = "https://aip.baidubce.com/rest/2.0/image-classify/v1/car";//车型
    public final static String LOGO_DISCERN = "https://aip.baidubce.com/rest/2.0/image-classify/v2/logo";//LOGO
    public final static String ANIMAL_DISCERN = "https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";//动物
    public final static String FLOWER_DISCERN = "https://aip.baidubce.com/rest/2.0/image-classify/v1/flower";//花卉
    public final static String INGREDIENT_DISCERN = "https://aip.baidubce.com/rest/2.0/image-classify/v1/classify/ingredient";//果蔬
    public final static String MAGNIFY_DISCERN = "https://aip.baidubce.com/rest/2.0/image-classify/v1/image_quality_enhance";//放大图片
    public final static String DEHAZE_DISCERN = "https://aip.baidubce.com/rest/2.0/image-classify/v1/dehaze";//图片去雾
    public final static String DBD_DISCERN = "https://aip.baidubce.com/rest/2.0/image-classify/v1/contrast_enhance";//图片对比度增强
    public static String TOKEN = AuthService.getAuth();//令牌
}
