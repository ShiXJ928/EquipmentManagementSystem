package com.zq.ems.bean;

/**
 * Created by AIERXUAN on 2018/6/2.
 */

public class EquipmentBean {

    private String photoPath;
    private String name;
    private String stautes;
    private String time;
    private int type;

    public EquipmentBean() {
    }

    public EquipmentBean(String photoPath, String name) {
        this.photoPath = photoPath;
        this.name = name;
    }

    public EquipmentBean(String photoPath, String name, String stautes, String time, int type) {
        this.photoPath = photoPath;
        this.name = name;
        this.stautes = stautes;
        this.time = time;
        this.type = type;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStautes() {
        return stautes;
    }

    public void setStautes(String stautes) {
        this.stautes = stautes;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
