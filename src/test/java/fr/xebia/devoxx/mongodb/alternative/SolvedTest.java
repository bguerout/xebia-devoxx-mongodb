package fr.xebia.devoxx.mongodb.alternative;

import com.mongodb.*;
import fr.xebia.devoxx.mongodb.domain.Tweet;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

public class SolvedTest {

    private DBCollection collection;

    @Before
    public void setUp() throws Exception {
        Mongo mongo = new Mongo("127.0.0.1", 27017);
        DB db = mongo.getDB("devoxx");
        collection = db.getCollection("tweets");
    }

    @Test
    public void saveThisTweet() throws Exception {

        Tweet tweet = new Tweet("100000", "XebiaFR", new Date(), "Discovering #mongodb");

        DBObject dbObject = new BasicDBObject();
        dbObject.put("from_user_id", tweet.getUserId());
        dbObject.put("from_user_name", tweet.getUserName());
        dbObject.put("created_at", tweet.getCreateAt());
        dbObject.put("text", tweet.getText());

        collection.save(dbObject, WriteConcern.SAFE);

        assertThat(collection.count()).isGreaterThan(0);
    }

    @Test
    public void findATweetFromXebia() throws Exception {

        DBObject query = new BasicDBObject("from_user_name", "XebiaFR");

        DBObject result = collection.findOne(query);

        assertThat(result).isNotNull();

        String from_user_id = (String) result.get("from_user_id");
        String from_user_name = (String) result.get("from_user_name");
        Date created_at = new Date((Long) result.get("created_at"));
        String text = (String) result.get("text");

        Tweet tweet = new Tweet(from_user_id, from_user_name, created_at, text);
        assertThat(tweet.getUserName()).isEqualTo("XebiaFR");
    }
}
