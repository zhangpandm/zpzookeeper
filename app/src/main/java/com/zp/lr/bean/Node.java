package com.zp.lr.bean;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: zhangpanm
 * @Date: 2020/8/3
 * @Description:
 */
public class Node {

    private String zkSeqNO;

    private boolean isMaster;

    private AtomicInteger version=new AtomicInteger();

    public String getZkSeqNO() {
        return zkSeqNO;
    }

    public void setZkSeqNO(String zkSeqNO) {
        this.zkSeqNO = zkSeqNO;
    }

    public boolean isMaster() {
        return isMaster;
    }

    public void setMaster(boolean master) {
        isMaster = master;
    }

    public boolean checkMaster(List<String> childrens){
        Collections.sort(childrens);
        if(null == childrens||childrens.isEmpty()){
            return false;
        }
       return  this.zkSeqNO.equals(childrens.get(0));
    }

    public int getVersion() {
        return version.get();
    }

    public int increase() {
        return  this.version.incrementAndGet();
    }
}
