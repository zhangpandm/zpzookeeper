package com.zp.lr.server;

import com.alibaba.fastjson.JSON;
import com.zp.lr.bean.Node;
import com.zp.lr.config.ZookeeperConfig;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: zhangpanm
 * @Date: 2020/8/3
 * @Description:
 */
@Service
public class ZookeeperLockService {
    private Logger logger = LoggerFactory.getLogger(ZookeeperLockService.class);
    @Autowired
    private ZooKeeper zkClient;
    private Node node;

    private String rootNode="/zpjob";

    private AtomicInteger version=new AtomicInteger();

    public void testMaster(String jobName) throws KeeperException, InterruptedException {
        paretentExists();


        List<String> childrens = getChildrens();
        if(null == node || StringUtils.isEmpty(node.getZkSeqNO()) || childrens.contains(node.getZkSeqNO())){
            String nodeString = create(rootNode+"/"+jobName);
            logger.info(nodeString);
            node = new Node();
            node.setZkSeqNO(nodeString);
        }
        if(node.checkMaster(childrens)){//主节点发布任务
            //distributeJob(childrens);
            node.setMaster(true);
        }
        listennerNode(node.getZkSeqNO());

    }

    public void distributeJob(List<String> childrens){
       childrens.forEach(s -> {
           try {
               Stat stat=zkClient.exists(rootNode+"/"+s,false);
               zkClient.setData(rootNode+"/"+s, UUID.randomUUID().toString().getBytes(),stat.getVersion());
           } catch (KeeperException e) {
               e.printStackTrace();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });
    }

    private void listennerNode(String nodePath) throws KeeperException, InterruptedException {

        final Stat stat = new Stat();
        byte[] nodeData = zkClient.getData(node.getZkSeqNO(), new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                logger.info("event {}",JSON.toJSONString(event));
                Event.KeeperState st = event.getState();
                try {
                    listennerNode(nodePath);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },stat);

        processJob(nodeData);
    }

    private void processJob(byte[] nodeData){
        logger.info("process nodeData {}",new String(nodeData));
    }

    public List<String> getChildrens()throws KeeperException, InterruptedException{
        if(!exists(rootNode)){
            create(rootNode,CreateMode.PERSISTENT);
        }
        List<String> childrenes = zkClient.getChildren(rootNode, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                logger.info("getChildren {}",JSON.toJSONString(event));
            }
        });
        return childrenes;
    }
    private boolean paretentExists ()  {
        boolean res=false;
        List<String> childrenes = null;
        try {
            childrenes = getChildrens();
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return  null != childrenes && !childrenes.isEmpty();
    }
    private boolean exists(String path){
        boolean res =false;
        try {
            Stat stat = zkClient.exists(path,false);
            logger.info("stat {}", JSON.toJSONString(stat));
            return null != stat;
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }
    private String create(String path,CreateMode createMode) throws KeeperException, InterruptedException {
        List<ACL> acls = new ArrayList<>();
        int prems = ZooDefs.Perms.ALL;//Acl权限或运算
        ACL acl = new ACL(prems,new Id("world","anyone"));
        acls.add(acl);
        return zkClient.create(path,"nb2020".getBytes(),acls, createMode);
    }

    private String create(String path) throws KeeperException, InterruptedException {
       return  create(path,CreateMode.EPHEMERAL_SEQUENTIAL);
    }



}
