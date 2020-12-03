package com.zp.lr.config;

import org.redisson.config.Config;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/4
 * @Description:
 */

public class RedisConfig2 {

    public Config getRedissonConfig(){
        Config  config = new Config();
        config.useClusterServers().addNodeAddress("192.168.125.129:8001")
        .addNodeAddress("192.168.125.129:8004")
        .addNodeAddress("192.168.125.11:8001")
        .addNodeAddress("192.168.125.11:8004")
        .addNodeAddress("192.168.125.12:8001")
        .addNodeAddress("192.168.125.12:8004").setPassword("zpdm1234").setConnectTimeout(2000).
                setMasterConnectionPoolSize(100).setMasterConnectionMinimumIdleSize(2);
         return  config;
        }
}
