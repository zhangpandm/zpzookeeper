package com.zp.lr.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/29
 * @Description:
 */
@Configuration
public class RedisConfig {
    private  static Logger log = LoggerFactory.getLogger(RedisConfig.class);

    /**
     * RedissonConfig
     * @return
     */
    @Bean
    public Config getRedissonConfig(){
        log.info("###################online-common useClusterServers :192.168.125.129:8001&&&&&&&&&&&&");
        Config  config = new Config();
        config.useClusterServers().addNodeAddress("redis://192.168.125.129:8001")
                .addNodeAddress("redis://192.168.125.129:8004")
                .addNodeAddress("redis://192.168.125.11:8001")
                .addNodeAddress("redis://192.168.125.11:8004")
                .addNodeAddress("redis://192.168.125.12:8001")
                .addNodeAddress("redis://192.168.125.12:8004").setPassword("zpdm1234").setConnectTimeout(2000).
                setMasterConnectionPoolSize(100).setMasterConnectionMinimumIdleSize(2);
        return  config;

    }

    /**
     *
     * @return
     */
    @Bean
    public Redisson getRedisson(){
        return (Redisson) Redisson.create(getRedissonConfig());
    }
}
