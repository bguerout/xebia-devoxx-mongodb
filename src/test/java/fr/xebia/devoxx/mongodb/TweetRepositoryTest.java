package fr.xebia.devoxx.mongodb;

import com.mongodb.*;
import fr.xebia.devoxx.mongodb.domain.Tweet;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/*
1. Unpack distribution and start MongoDB

    mkdir data
    ./mongod --dbpath ./data

2. Import tweets data by running this command line :

    ./mongoimport --upsert -d devoxx -c tweets --drop --jsonArray tweets.json


3. Try MongoShell, run 'count' and 'find' operations with the following queries

    db.tweets.count();
    db.tweets.findOne({from_user:'ericlemerdy'});


4. Implement 2 following tests with mongo-java-driver

5. Had a look at WithJongoTest and WithMorphiaTest to see mongo-java-driver alternatives
*/
public class TweetRepositoryTest {

    private DBCollection collection;

    @Before
    public void setUp() throws Exception {
        Mongo mongo = new Mongo("127.0.0.1", 27017);
        DB db = mongo.getDB("devoxx");
        collection = db.getCollection("fresh-tweets");
    }

    /*
        Beware of default writeconcern
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


    /*
    A tweet as BSON Mongo Document.
    {
    	"_id" : ObjectId("4f8f280f23e9359fda81cc91"),
    	"created_at" : "Wed, 18 Apr 2012 18:47:31 +0000",
    	"from_user" : "ericlemerdy",
    	"from_user_id" : 17173023,
    	"from_user_id_str" : "17173023",
    	"from_user_name" : "Eric Le Merdy",
    	"geo" : null,
    	"id" : NumberLong("192685809969790977"),
    	"id_str" : "192685809969790977",
    	"iso_language_code" : "fr",
    	"metadata" : {
    		"result_type" : "recent"
    	},
    	"profile_image_url" : "http://a0.twimg.com/profile_images/63613120/rect3264_normal.png",
    	"profile_image_url_https" : "https://si0.twimg.com/profile_images/63613120/rect3264_normal.png",
    	"source" : "&lt;a href=&quot;http://seesmic.com/&quot; rel=&quot;nofollow&quot;&gt;Seesmic&lt;/a&gt;",
    	"text" : "Les polos rouges à l'honneur #devoxxfr http://t.co/QNyiYLXx",
    	"to_user" : null,
    	"to_user_id" : null,
    	"to_user_id_str" : null,
    	"to_user_name" : null
    }

     */

}
