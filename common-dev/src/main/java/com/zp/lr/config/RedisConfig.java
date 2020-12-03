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
        log.info("###################dev-redisson url:132.232.23.116:6379^^^^^^^^^");
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+"132.232.23.116:6379").setDatabase(0)
                .setPassword("zpdm1234").setConnectionPoolSize(30).setConnectionMinimumIdleSize(2).setConnectTimeout(20000);

        return config;
    }

    /**
     *
     * @return
     */
    @Bean
    public Redisson getRedisson(){
        log.info("###################dev-redisson url:132.232.23.116:6379");
        return (Redisson) Redisson.create(getRedissonConfig());
    }
}
