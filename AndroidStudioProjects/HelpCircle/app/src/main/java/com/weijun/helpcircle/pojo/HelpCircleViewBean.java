package com.weijun.helpcircle.pojo;

import java.util.ArrayList;
import java.util.List;

public class HelpCircleViewBean {


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
}
