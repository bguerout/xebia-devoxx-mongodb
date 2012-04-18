package fr.xebia.devoxx.mongodb.alternative.jongo;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

public class JongoTweet {

    @JsonProperty("from_user_id")
    private String userId;
    @JsonProperty("from_user_name")
    private String userName;
    @JsonProperty("created_at")
    private Date createAt;
    private String text;


    public JongoTweet(String userId, String userName, Date createAt, String text) {
        this.userId = userId;
        this.userName = userName;
        this.createAt = createAt;
        this.text = text;
    }

    public JongoTweet() {
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
