package com.zp.lr.server;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/4
 * @Description:
 */
@Service
public class RedisLockService {

    private Integer  noLockCout =0;
    private Integer  lockCout =0;

    private Logger logger = LoggerFactory.getLogger(RedisLockService.class);
    @Autowired
    private Redisson redisson;
    public void NoDisLockTest(){
        noLockCout++;
    }

    public void disLockTest(String lockName){
        RLock lock = redisson.getLock(lockName);
        lock.lock();
        lockCout++;
        logger.info("disLockTest:"+lockCout);
        lock.unlock();
    }

    public Integer getNoLockCout() {
        return noLockCout;
    }


    public Integer getLockCout() {
        return lockCout;
    }


}
