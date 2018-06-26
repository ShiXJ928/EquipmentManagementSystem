package com.zq.ems.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by AIERXUAN on 2018/6/21.
 */

public class RecordBean implements Parcelable {

    /**
     * logtime : 2018-03-26T14:49:52
     * username : 王曦平
     * action : 领取
     * qty : 1
     * rightQty : 6
     * missQty : 5
     * tools : 多功能腰带,伸缩警棍
     * rightTools : 多功能腰带,手铐,伸缩警棍,催泪喷射器,对讲机,防割手套
     */

    private String logtime;
    private String username;
    private String action;
    private int qty;
    private int rightQty;
    private int missQty;
    private String tools;
    private String rightTools;

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getRightQty() {
        return rightQty;
    }

    public void setRightQty(int rightQty) {
        this.rightQty = rightQty;
    }

    public int getMissQty() {
        return missQty;
    }

    public void setMissQty(int missQty) {
        this.missQty = missQty;
    }

    public String getTools() {
        if (tools == null) {
            return "";
        }
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public String getRightTools() {
        if (rightTools == null) {
            return "";
        }
        return rightTools;
    }

    public void setRightTools(String rightTools) {
        this.rightTools = rightTools;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.logtime);
        dest.writeString(this.username);
        dest.writeString(this.action);
        dest.writeInt(this.qty);
        dest.writeInt(this.rightQty);
        dest.writeInt(this.missQty);
        dest.writeString(this.tools);
        dest.writeString(this.rightTools);
    }

    public RecordBean() {
    }

    protected RecordBean(Parcel in) {
        this.logtime = in.readString();
        this.username = in.readString();
        this.action = in.readString();
        this.qty = in.readInt();
        this.rightQty = in.readInt();
        this.missQty = in.readInt();
        this.tools = in.readString();
        this.rightTools = in.readString();
    }

    public static final Parcelable.Creator<RecordBean> CREATOR = new Parcelable.Creator<RecordBean>() {
        @Override
        public RecordBean createFromParcel(Parcel source) {
            return new RecordBean(source);
        }

        @Override
        public RecordBean[] newArray(int size) {
            return new RecordBean[size];
        }
    };
}
