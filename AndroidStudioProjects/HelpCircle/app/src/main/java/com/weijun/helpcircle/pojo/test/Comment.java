package com.weijun.helpcircle.pojo.test;

import com.weijun.helpcircle.pojo.User;

public class Comment {

    private User user;

    private String content;

    public Comment(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public Comment() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
