package com.zq.ems.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SXJ on 2018/8/15 09:29
 * E-Mail Address：2394905398@qq.com
 */

public class ApplyEquipmentBean implements Parcelable {
    private String name;
    private int num;

    public ApplyEquipmentBean() {
    }

    public ApplyEquipmentBean(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.num);
    }

    protected ApplyEquipmentBean(Parcel in) {
        this.name = in.readString();
        this.num = in.readInt();
    }

    public static final Parcelable.Creator<ApplyEquipmentBean> CREATOR = new Parcelable.Creator<ApplyEquipmentBean>() {
        @Override
        public ApplyEquipmentBean createFromParcel(Parcel source) {
            return new ApplyEquipmentBean(source);
        }

        @Override
        public ApplyEquipmentBean[] newArray(int size) {
            return new ApplyEquipmentBean[size];
        }
    };
}
