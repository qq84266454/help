package com.weijun.helpcircle.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class HelpCircleViewBean implements Parcelable {


    public String getPublisherNickname() {
        return publisherNickname;
    }

    public void setPublisherNickname(String publisherNickname) {
        this.publisherNickname = publisherNickname;
    }

    public String getHc_type() {
        return hc_type;
    }

    public void setHc_type(String hc_type) {
        this.hc_type = hc_type;
    }

    public String getAll_can_see_time() {
        return all_can_see_time;
    }

    public void setAll_can_see_time(String all_can_see_time) {
        this.all_can_see_time = all_can_see_time;
    }

    public String getMsg_count() {
        return msg_count;
    }

    public void setMsg_count(String msg_count) {
        this.msg_count = msg_count;
    }

    /**
     * publisherNickname : ID70的昵称
     * hc_type : 3
     * all_can_see_time : 2018-09-23 13:41:59
     * location_id : null
     * msg_count : 8
     * msg_string : [{"reciever":"社群客服备用","replyer":"王三","hcm_id":"62","reply_id":"3","recieve_id":"74","reply_content":"12121212","reply_time":"2018-09-25 11:52:07","help_circle_id":"35"},{"reciever":"ID70的昵称","replyer":"王三","hcm_id":"61","reply_id":"3","recieve_id":"2","reply_content":"4","reply_time":"2018-09-25 11:36:01","help_circle_id":"35"},{"reciever":"ID73的昵称","replyer":"王三","hcm_id":"60","reply_id":"3","recieve_id":"73","reply_content":"3123213123","reply_time":"2018-09-25 11:31:45","help_circle_id":"35"},{"reciever":"ID70的昵称","replyer":"社群客服备用","hcm_id":"45","reply_id":"74","recieve_id":"2","reply_content":"回复李二的效果","reply_time":"2018-09-15 15:13:33","help_circle_id":"35"},{"reciever":"ID73的昵称","replyer":"ID72的昵称","hcm_id":"42","reply_id":"72","recieve_id":"73","reply_content":"123","reply_time":"2018-09-13 22:16:36","help_circle_id":"35"},{"reciever":"ID70的昵称","replyer":"ID72的昵称","hcm_id":"41","reply_id":"72","recieve_id":"2","reply_content":"i love you","reply_time":"2018-09-12 23:31:47","help_circle_id":"35"},{"reciever":"ID73的昵称","replyer":"ID72的昵称","hcm_id":"40","reply_id":"72","recieve_id":"73","reply_content":"i","reply_time":"2018-09-12 23:31:33","help_circle_id":"35"},{"reciever":"ID70的昵称","replyer":"ID73的昵称","hcm_id":"37","reply_id":"73","recieve_id":"2","reply_content":"00073回复 00002 AAA","reply_time":"2018-09-12 08:51:45","help_circle_id":"35"}]
     */

    private String publisherNickname;
    private String hc_type;
    private String all_can_see_time;
    private String msg_count;

    public HelpCircleViewBean() {

    }


    protected HelpCircleViewBean(Parcel in) {
        publisherNickname = in.readString();
        hc_type = in.readString();
        all_can_see_time = in.readString();
        msg_count = in.readString();
        msgBeans = in.createTypedArrayList(HelpCircleMsgBean.CREATOR);
        helpCircleID = in.readString();
        helpCirclePublisher = in.readString();
        helpCircleContent = in.readString();
        coin_total = in.readString();
        coin_available = in.readString();
        publish_time = in.readString();
        location_id = in.readString();
        img_url = in.readString();
        view_times = in.readString();
    }

    public static final Creator<HelpCircleViewBean> CREATOR = new Creator<HelpCircleViewBean>() {
        @Override
        public HelpCircleViewBean createFromParcel(Parcel in) {
            return new HelpCircleViewBean(in);
        }

        @Override
        public HelpCircleViewBean[] newArray(int size) {
            return new HelpCircleViewBean[size];
        }
    };

    public List<HelpCircleMsgBean> getMsgBeans() {
        if (msgBeans == null) {
            msgBeans = new ArrayList<>();
        }
        return msgBeans;
    }

    public void setMsgBeans(List<HelpCircleMsgBean> msgBeans) {
        this.msgBeans = msgBeans;
    }

    /**
     * helpCircleID : 3
     * helpCirclePublisher : 1
     * helpCircleContent : 有谁认识江岸区的税务领导、朋友有急事帮忙、重谢
     * coin_total : 100.00000
     * coin_available : 58.00000
     * publish_time : 2018-08-04 12:28:00
     * location_id : null
     * img_url : _3_WechatIMG124.jpeg;_3_WechatIMG125.jpeg;_3_WechatIMG126.jpeg
     */

    private List<HelpCircleMsgBean> msgBeans;
    private String helpCircleID;
    private String helpCirclePublisher;
    private String helpCircleContent;
    private String coin_total;
    private String coin_available;
    private String publish_time;
    private String location_id;
    private String img_url;
    private String view_times;

    public String getHelpCircleID() {
        return helpCircleID;
    }

    public void setHelpCircleID(String helpCircleID) {
        this.helpCircleID = helpCircleID;
    }

    public String getHelpCirclePublisher() {
        return helpCirclePublisher;
    }

    public void setHelpCirclePublisher(String helpCirclePublisher) {
        this.helpCirclePublisher = helpCirclePublisher;
    }

    public String getHelpCircleContent() {
        return helpCircleContent;
    }

    public void setHelpCircleContent(String helpCircleContent) {
        this.helpCircleContent = helpCircleContent;
    }

    public String getCoin_total() {
        return coin_total;
    }

    public void setCoin_total(String coin_total) {
        this.coin_total = coin_total;
    }

    public String getCoin_available() {
        return coin_available;
    }

    public void setCoin_available(String coin_available) {
        this.coin_available = coin_available;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getView_times() {
        return view_times;
    }

    public void setView_times(String view_times) {
        this.view_times = view_times;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(publisherNickname);
        dest.writeString(hc_type);
        dest.writeString(all_can_see_time);
        dest.writeString(msg_count);
        dest.writeTypedList(msgBeans);
        dest.writeString(helpCircleID);
        dest.writeString(helpCirclePublisher);
        dest.writeString(helpCircleContent);
        dest.writeString(coin_total);
        dest.writeString(coin_available);
        dest.writeString(publish_time);
        dest.writeString(location_id);
        dest.writeString(img_url);
        dest.writeString(view_times);
    }

}
