package com.zq.ems.bean;

/**
 * Created by AIERXUAN on 2018/6/2.
 */

public class TeachingMateriaBean {

    private String path;
    private String photoPath;
    private String name;
    private String type;

    public TeachingMateriaBean() {
    }

    public TeachingMateriaBean(String path, String photoPath, String name, String type) {
        this.path = path;
        this.photoPath = photoPath;
        this.name = name;
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
