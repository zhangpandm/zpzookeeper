package com.zp.lr.controller;

import com.zp.lr.server.RedisLockService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/4
 * @Description:
 */
@RestController
public class RedisLockController {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private Redisson redisson;
    @Autowired
    private RedisLockService redisLockService;

    private Logger logger = LoggerFactory.getLogger(RedisLockController.class);

    @RequestMapping(value = "/testSetkey",method = RequestMethod.POST)
    public String testSetkey(String key ,String value,Long expire){
        redisTemplate.opsForValue().set(key,value,expire, TimeUnit.SECONDS);
        return "test";
    }
    @RequestMapping(value = "/getKeyValue",method = RequestMethod.GET)
    public String getKeyValue(String key){
        String res = redisTemplate.opsForValue().get(key);
        return res;
    }
    @RequestMapping(value = "/testRedisLock",method = RequestMethod.GET)
    public String testRedisLock(){
        RLock lock = redisson.getLock("zpt");
        lock.lock();
        int i=0;
        i +=3;
        boolean r =lock.forceUnlock();
        logger.warn("redis lock test unlock "+r);
        return i+"";
    }
    @RequestMapping(value = "/testRedisLockThreds",method = RequestMethod.POST)
    public Map testRedisLockThreds(Integer threads) throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(threads);
        for(int i=0;i<threads;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    redisLockService.NoDisLockTest();
                    redisLockService.disLockTest("testRedisLockThreds");
                    downLatch.countDown();
                }
            }).start();
        }
        downLatch.await();
        Map map = new HashMap();
        map.put("LockCout",redisLockService.getLockCout());
        map.put("getNoLockCout",redisLockService.getNoLockCout());
        return map;
    }
}
