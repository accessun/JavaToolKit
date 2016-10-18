package io.github.accessun.mongodb;

import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * 需求： 1. 从MongoDB中快速读入数据，每个读入的文档都储存在了一个Document中，它实际上是一个HashMap
 * 
 * @author User
 */
public class TestMongoDBConnection {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    private String dbName = "test";
    private String colName = "posts";

    @Before
    public void getClientAndDataBase() {
        this.client = new MongoClient("127.0.0.1", 27017);
        this.database = client.getDatabase(dbName);
        this.collection = database.getCollection(colName);
    }

    @After
    public void closeClient() {
        this.client.close();
    }

    @Test
    public void testDBConnection() {
        System.out.println(client);
        System.out.println(database);
    }

    @Test
    public void testGetAllDocuments() {
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }
    
    @Test
    public void testGetDocumentWithCriteria() {
        Document criteria = new Document("status", "non-active");
        Document result = collection.find(criteria).first();
        System.out.println(result.toJson());
    }
    
    @Test
    public void testGetDocumentsWithCriteria2() {
        BasicDBObject query = new BasicDBObject();
        query.put("tags.0", "mongodb");
        
        MongoCursor<Document> results = collection.find(query).iterator();
        try {
            while (results.hasNext())
                System.out.println(results.next().toJson());
        } finally {
            results.close();
        }
    }

    @Test
    public void testGetDocumentsWithCriteria3() {
        // db.posts.find({ "person.teacher.name": "lucy" })
        BasicDBObject query = null;
        query = new BasicDBObject("person.teacher.name", "lucy");
        
        MongoCursor<Document> results = collection.find(query).iterator();
        try {
            while (results.hasNext())
                System.out.println(results.next().toJson());
        } finally {
            results.close();
        }
    }
    
    @Test
    public void testGetDocumentsWithCriteria4() {
        // db.posts.find({ "person.teacher.name": "lucy" })
        Document query = new Document("person.teacher.name", "lucy");
        MongoCursor<Document> results = collection.find(query).iterator();
        try {
            while (results.hasNext())
                System.out.println(results.next().toJson());
        } finally {
            results.close();
        }
    }
    
    
    @Test
    public void testGetDocumentsWithCriteria5() {
        // db.posts.find({ "likes": { "$gte": 100 } })
        Bson filter = Filters.eq("likes", Filters.eq("$gte", 100));

        FindIterable<Document> iter = collection.find(filter);
        for (Document document : iter) {
            printDocument(document);
        }
    }


    private void printDocument(Document document) {
        for (Map.Entry<String, Object> entry : document.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
