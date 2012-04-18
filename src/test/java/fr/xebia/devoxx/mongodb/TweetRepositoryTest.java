package fr.xebia.devoxx.mongodb;

import com.mongodb.*;
import fr.xebia.devoxx.mongodb.domain.Tweet;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/*
1. Unpack MongoDB distribution


2. Import tweets data by running this command line :

    mongoimport --upsert -d devoxx -c tweets --drop --jsonArray tweets.json


3. Try MongoShell, run 'count' and 'find' operations with the following queries

    db.tweets.count();
    db.tweets.findOne({from_user:'ericlemerdy'});

4. Implement 2 following tests  with mongo-java-driver

5. Had a look at WithJongoTest and WithMorphiaTest to see mongo-java-driver alternatives
*/
public class TweetRepositoryTest {

    private DBCollection collection;

    @Before
    public void setUp() throws Exception {
        Mongo mongo = new Mongo("127.0.0.1", 27017);
        DB db = mongo.getDB("devoxx");
        collection = db.getCollection("tweets");
    }

    /*
          Beware of default writeconcern
          Polymorphism is not handled by default
     */
    @Test
    public void saveThisTweet() throws Exception {
        Tweet tweet = new Tweet("100000", "XebiaFR", new Date(), "Discovering #mongodb");
    }

    /*
          Java driver query and mapping can be painful.
          Mongo queries are written in bson (ie. DBObject in java-driver)
     */
    @Test
    public void findATweetFromXebia() throws Exception {
        DBObject query = new BasicDBObject("from_user_name", "XebiaFR");
    }


}
