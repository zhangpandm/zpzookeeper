package com.zp.lr.controller;

import com.zp.lr.server.ZookeeperLockService;
import org.apache.zookeeper.KeeperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhangpanm
 * @Date: 2020/8/3
 * @Description:
 */
@RestController
public class ZookeeperController {
    @Autowired
    ZookeeperLockService zookeeperService;

    @RequestMapping("/testZookeeperLock")
    public Map<String,String> testZookeeperLock(String jobName) throws KeeperException, InterruptedException {
        Map<String,String> result = new HashMap<>();
        result.put("status","ok");
        zookeeperService.testMaster(jobName);
        return result;
    }
    @RequestMapping("/distributeJob")
    public Map<String,String> distributeJobName() throws KeeperException, InterruptedException {
        Map<String,String> result = new HashMap<>();
        result.put("status","ok");
        zookeeperService.distributeJob(zookeeperService.getChildrens());
        return result;
    }
}
