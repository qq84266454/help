package com.weijun.helpcircle.pojo;

import com.weijun.helpcircle.pojo.test.Helper;

import java.util.List;

public class Community {
    public Community(String name) {
        this.name = name;
    }

    public Community(List<String> pics, List<Helper> helpers, List<User> activeUser, Long popValue, String logo, String name) {
        this.pics = pics;
        this.helpers = helpers;
        this.activeUser = activeUser;
        this.popValue = popValue;
        this.logo = logo;
        this.name = name;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public List<Helper> getHelpers() {
        return helpers;
    }

    public void setHelpers(List<Helper> helpers) {
        this.helpers = helpers;
    }

    public List<User> getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(List<User> activeUser) {
        this.activeUser = activeUser;
    }

    public Long getPopValue() {
        return popValue;
    }

    public void setPopValue(Long popValue) {
        this.popValue = popValue;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<String> pics;
    private List<Helper> helpers;
    private List<User> activeUser;
    private Long popValue;
    private String logo;
    private String name;
}
