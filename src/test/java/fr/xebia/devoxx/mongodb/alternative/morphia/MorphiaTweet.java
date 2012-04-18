package fr.xebia.devoxx.mongodb.alternative.morphia;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

import java.util.Date;

@Entity("tweets")
public class MorphiaTweet {

    @Property("from_user_id")
    private String userId;
    @Property("from_user_name")
    private String userName;
    @Property("created_at")
    private Date createAt;
    private String text;

    public MorphiaTweet(String userId, String userName, Date createAt, String text) {
        this.createAt = createAt;
        this.text = text;
        this.userId = userId;
        this.userName = userName;
    }

    //Morphia's constructor
    public MorphiaTweet() {
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
