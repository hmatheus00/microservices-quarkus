package com.acesso.models;

public class UserInfo {
    private String userId;
    private String name;
    private String email;
    private String image;
    private UserAccountInfo userAccountInfo;

    public UserInfo() {
    }

    public UserInfo(String userId, String name, String email, String image, UserAccountInfo userAccountInfo) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.image = image;
        this.userAccountInfo = userAccountInfo;
    }

    public UserInfo(String userId, String name, String email, String image) {
        this(userId, name, email, image, new UserAccountInfo());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserAccountInfo getUserAccountInfo() {
        return userAccountInfo;
    }

    public void setUserAccountInfo(UserAccountInfo userAccountInfo) {
        this.userAccountInfo = userAccountInfo;
    }
}

