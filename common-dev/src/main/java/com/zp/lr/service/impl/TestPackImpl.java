package com.zp.lr.service.impl;
import com.zp.lr.service.TestPack;
import org.springframework.stereotype.Service;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/27
 * @Description:
 */
@Service
public class TestPackImpl implements TestPack {
    public String packInfo(){
        return "commom-dev info 12345";
    }
}
