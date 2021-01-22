package com.zp.lr.test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * @Auther: zhangpanm
 * @Date: 2021/1/19
 * @Description:
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class mongoTest {
    MongoDatabase database;

    @BeforeAll
    void init(){
        MongoClient mongoClient = new MongoClient( "132.232.23.116" , 27017 );
        database = mongoClient.getDatabase("test");
    }

    @Test
    void testFind(){

        MongoCursor mc = database.getCollection("friend").find().iterator();
        while (mc.hasNext()){
           Object ob = mc.next();
            System.out.println(ob+"");
        }
    }
}
