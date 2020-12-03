package com.zp.lr.config;

import com.zp.lr.controller.RedisLockController;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: zhangpanm
 * @Date: 2020/8/3
 * @Description:
 */
@Configuration
public class ZookeeperConfig {
    private Logger logger = LoggerFactory.getLogger(ZookeeperConfig.class);
    //zookeeper.address
    private String zookeeperAddr="132.232.23.116:2181";

    private  int timeout=60*1000;
    @Bean
    public ZooKeeper zkClient() throws InterruptedException {
        ZooKeeper zooKeeper=null;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            zooKeeper = new ZooKeeper(zookeeperAddr, timeout, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    if (Watcher.Event.KeeperState.SyncConnected.equals(watchedEvent.getState())){
                        logger.info("连接成功" + watchedEvent);
                        countDownLatch.countDown();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("开始连接....." );
        if (ZooKeeper.States.CONNECTING.equals(zooKeeper.getState())){
            logger.info("连接中");
            countDownLatch.await();
        }
        return zooKeeper;
    }
}
