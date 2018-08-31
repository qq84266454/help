package com.weijun.helpcircle.pojo.test;


import com.weijun.helpcircle.pojo.User;

import java.util.List;

public class Helper {
    public Helper(User user, String title, int reward, String img, String address, List<User> refUser, String time, int seen, int fav, int reSend, List<Comment> comments, List<User> helpers) {
        this.user = user;
        this.title = title;
        this.reward = reward;
        this.img = img;
        this.address = address;
        this.refUser = refUser;
        this.time = time;
        this.seen = seen;
        this.fav = fav;
        this.reSend = reSend;
        this.comments = comments;
        this.helpers = helpers;
    }

    public Helper() {
    }

    public Helper(User user, String title, int reward, String img, String address, List<User> refUser, String time, int seen, int fav, int reSend, List<Comment> comments) {
        this.user = user;
        this.title = title;
        this.reward = reward;
        this.img = img;
        this.address = address;
        this.refUser = refUser;
        this.time = time;
        this.seen = seen;
        this.fav = fav;
        this.reSend = reSend;
        this.comments = comments;
    }


    private User user;

    private String title;

    private int reward;

    private String img;

    private String address;

    public List<User> getRefUser() {
        return refUser;
    }

    public void setRefUser(List<User> refUser) {
        this.refUser = refUser;
    }

    private List<User> refUser;

    private String time;

    private int seen;

    private int fav;

    private int reSend;

    private List<Comment> comments;

    private List<User> helpers;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSeen() {
        return seen;
    }

    public void setSeen(int seen) {
        this.seen = seen;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public int getReSend() {
        return reSend;
    }

    public void setReSend(int reSend) {
        this.reSend = reSend;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getHelpers() {
        return helpers;
    }

    public void setHelpers(List<User> helpers) {
        this.helpers = helpers;
    }
}
