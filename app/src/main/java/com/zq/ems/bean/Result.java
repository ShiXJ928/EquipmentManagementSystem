package com.zq.ems.bean;

/**
 * Created by sxj on 2016/9/29.
 */
public class Result {
    private String msg;
    private boolean success;
    private Object records;

    public String getMsg() {
        if (msg == null) {
            return "";
        }
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getRecords() {
        return records;
    }

    public void setRecords(Object records) {
        this.records = records;
    }
}
