package fr.xebia.devoxx.mongodb.alternative.jongo;

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

public class WithJongoTest {

    private MongoCollection collection;

    @Before
    public void setUp() throws Exception {

        Mongo mongo = new Mongo("127.0.0.1", 27017);
        DB db = mongo.getDB("devoxx");
        Jongo jongo = new Jongo(db);
        collection = jongo.getCollection("fresh-tweets");
    }

    @Test
    public void saveThisTweet() throws Exception {

        JongoTweet tweet = new JongoTweet("100000", "XebiaFR", new Date(), "Discovering #mongodb");

        collection.save(tweet);

        assertThat(collection.count("{}")).isGreaterThan(0);
    }

    @Test
    public void findATweetFromXebia() throws Exception {

        JongoTweet tweet = collection.findOne("{from_user_name: 'XebiaFR'}").as(JongoTweet.class);

        assertThat(tweet).isNotNull();
        assertThat(tweet.getUserName()).isEqualTo("XebiaFR");
    }
}
