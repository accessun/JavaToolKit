package io.github.accessun.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoCRUDTest {

    private static final String DB = "test";
    private static final String COL = "java_driver_test";

    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> col;

    @Before
    public void setUp() {
        client = new MongoClient("127.0.0.1", 27017);
        db = client.getDatabase(DB);
        this.col = db.getCollection(COL);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsertReplaceFind() {
        Document doc = new Document("x", 1);
        col.insertOne(doc);
        doc.append("x", 2).append("y", 4);

        col.replaceOne(Filters.eq("_id", doc.get("_id")), doc);

        List<Document> docs = col.find().into(new ArrayList<Document>());
        docs.forEach(System.out::println);
    }
}
