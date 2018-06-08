package com.zq.ems.bean;

/**
 * Created by AIERXUAN on 2018/6/2.
 */

public class OverdueEquipmentBean {

    private String name;
    private String overdueTime;
    private String lendTime;

    public OverdueEquipmentBean() {
    }

    public OverdueEquipmentBean(String name, String overdueTime, String lendTime) {
        this.name = name;
        this.overdueTime = overdueTime;
        this.lendTime = lendTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(String overdueTime) {
        this.overdueTime = overdueTime;
    }

    public String getLendTime() {
        return lendTime;
    }

    public void setLendTime(String lendTime) {
        this.lendTime = lendTime;
    }
}
