package com.weijun.helpcircle.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class HelpCircleMsgBean implements Parcelable{

    /**
     * hcm_Id : 10
     * reply_id : 3
     * reply_nick_name : 王三
     * recieve_id : null
     * recieve_nick_name : null
     * reply_content : 3发布的条目1。3回复所有人；
     * reply_time : 2018-08-06 11:00:10
     * help_circle_id : 1
     */

    private String hcm_Id;
    private String reply_id;
    private String reply_nick_name;
    private String recieve_id;
    private String recieve_nick_name;
    private String reply_content;
    private String reply_time;
    private String help_circle_id;

    public HelpCircleMsgBean(){

    }
    protected HelpCircleMsgBean(Parcel in) {
        hcm_Id = in.readString();
        reply_id = in.readString();
        reply_nick_name = in.readString();
        recieve_id = in.readString();
        recieve_nick_name = in.readString();
        reply_content = in.readString();
        reply_time = in.readString();
        help_circle_id = in.readString();
    }

    public static final Creator<HelpCircleMsgBean> CREATOR = new Creator<HelpCircleMsgBean>() {
        @Override
        public HelpCircleMsgBean createFromParcel(Parcel in) {
            return new HelpCircleMsgBean(in);
        }

        @Override
        public HelpCircleMsgBean[] newArray(int size) {
            return new HelpCircleMsgBean[size];
        }
    };

    public String getHcm_Id() {
        return hcm_Id;
    }

    public void setHcm_Id(String hcm_Id) {
        this.hcm_Id = hcm_Id;
    }

    public String getReply_id() {
        return reply_id;
    }

    public void setReply_id(String reply_id) {
        this.reply_id = reply_id;
    }

    public String getReply_nick_name() {
        return reply_nick_name;
    }

    public void setReply_nick_name(String reply_nick_name) {
        this.reply_nick_name = reply_nick_name;
    }

    public String getRecieve_id() {
        return recieve_id;
    }

    public void setRecieve_id(String recieve_id) {
        this.recieve_id = recieve_id;
    }

    public String getRecieve_nick_name() {
        return recieve_nick_name;
    }

    public void setRecieve_nick_name(String recieve_nick_name) {
        this.recieve_nick_name = recieve_nick_name;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public String getReply_time() {
        return reply_time;
    }

    public void setReply_time(String reply_time) {
        this.reply_time = reply_time;
    }

    public String getHelp_circle_id() {
        return help_circle_id;
    }

    public void setHelp_circle_id(String help_circle_id) {
        this.help_circle_id = help_circle_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hcm_Id);
        dest.writeString(reply_id);
        dest.writeString(reply_nick_name);
        dest.writeString(recieve_id);
        dest.writeString(recieve_nick_name);
        dest.writeString(reply_content);
        dest.writeString(reply_time);
        dest.writeString(help_circle_id);
    }
}
