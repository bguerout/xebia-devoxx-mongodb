package fr.xebia.devoxx.mongodb.alternative.morphia;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

public class WithMorphiaTest {

    private Datastore datastore;

    @Before
    public void setUp() throws Exception {

        Mongo mongo = new Mongo("127.0.0.1", 27017);
        datastore = new Morphia().createDatastore(mongo, "devoxx");
    }

    @Test
    public void saveThisTweet() throws Exception {

        MorphiaTweet tweet = new MorphiaTweet("100000", "XebiaFR", new Date(), "Discovering #mongodb");

        datastore.save(tweet, WriteConcern.SAFE);

        assertThat(datastore.getCount(MorphiaTweet.class)).isGreaterThan(0);
    }

    @Test
    public void findATweetFromXebia() throws Exception {

        MorphiaTweet result = datastore.find(MorphiaTweet.class).field("from_user_name").equal("XebiaFR").get();

        assertThat(result).isNotNull();
        assertThat(result.getUserName()).isEqualTo("XebiaFR");
    }
}
