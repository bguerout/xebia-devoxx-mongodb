package fr.xebia.devoxx.mongodb.solved;

import com.mongodb.*;
import fr.xebia.devoxx.mongodb.Speaker;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FinalUserRepositoryTest {

    private Speaker speaker;
    private DBCollection collection;

    @Before
    public void setUp() throws Exception {

        speaker = new Speaker("plopez", "Pablo Lopez");

        Mongo mongo = new Mongo();
        DB db = mongo.getDB("devoxx");
        collection = db.getCollection("speakers");
    }

    @Test
    public void canSaveUser() throws Exception {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("login", speaker.getLogin());
        dbObject.put("fullname", speaker.getFullname());

        collection.save(dbObject);

        assertThat(collection.count()).isGreaterThan(0);

    }

    @Test
    public void canFindUser() throws Exception {

        DBObject query = new BasicDBObject("login", "plopez");

        DBObject result = collection.findOne(query);

        assertThat(result.get("login")).isEqualTo("plopez");


    }
}
