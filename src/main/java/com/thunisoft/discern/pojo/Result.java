package com.thunisoft.discern.pojo;

public class Result {
    private String score;//置信度
    private String name;//名字
    private String year;//年份信息
    private baike_info baikeInfo;

    public baike_info getBaikeInfo() {
        return baikeInfo;
    }

    public void setBaikeInfo(baike_info baikeInfo) {
        this.baikeInfo = baikeInfo;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
