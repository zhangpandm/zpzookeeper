package com.zp.lr;


import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import com.zp.lr.controller.RedisLockController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;


import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: zhangpanm
 * @Date: 2021/1/20
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDbTest {
    private Logger logger = LoggerFactory.getLogger(MongoDbTest.class);


    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testFind(){
        Query query = new Query(Criteria.where("sex").is("female").and("age").gt(10));
       List<Map> dl = mongoTemplate.find(query,Map.class,"friend");
       for(Map m : dl){
           logger.info("{}",m);
       }
    }
    @Test
    public void testSave(){
        Map data = new HashMap();
        data.put("money",3235234);
        data.put("name","liangshicheng");
        data.put("sex","female");
        data.put("books","SanTi");
       mongoTemplate.save(data,"friend");
    }
    @Test
    public void testUpdate(){
        Query query = new Query(Criteria.where("name").is("liangshicheng"));
       mongoTemplate.updateMulti(query, Update.update("age",26),"friend");
    }
    @Test
    public void testAggregate(){
        Query query = new Query(Criteria.where("name").is("liangshicheng"));
    }
}
