package fr.xebia.devoxx.mongodb.domain;

import java.util.Date;

public class Tweet {

    private String userId;
    private String userName;
    private String text;
    private Date createAt;

    public Tweet(String userId, String userName, Date createAt, String text) {
        this.userId = userId;
        this.userName = userName;
        this.createAt = createAt;
        this.text = text;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public String getText() {
        return text;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
