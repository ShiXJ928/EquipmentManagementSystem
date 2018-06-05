package com.zq.ems.bean;

/**
 * Created by AIERXUAN on 2018/6/2.
 */

public class RemindBean {

    private String content;
    private String time;

    public RemindBean() {
    }

    public RemindBean(String content, String time) {
        this.content = content;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
