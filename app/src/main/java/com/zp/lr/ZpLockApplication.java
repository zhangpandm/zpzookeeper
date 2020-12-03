package com.zp.lr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Auther: zhangpanm
 * @Date: 2020/6/4
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "com.zp")
public class ZpLockApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZpLockApplication.class);
    }
}
