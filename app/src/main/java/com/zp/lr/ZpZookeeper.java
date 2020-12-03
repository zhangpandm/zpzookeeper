package com.zp.lr;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhangpanm
 * @Date: 2020/4/5
 * @Description:
 */
public class ZpZookeeper {

    private ZooKeeper zooKeeper;


    @Before
    public void init() throws IOException, InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        String conninfo ="132.232.23.116:2181";//ip:port,ip:port;
        try {
            zooKeeper = new ZooKeeper(conninfo, 4000, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
               //     System.out.println("zookeeper:"+watchedEvent.toString());
                    if (Watcher.Event.KeeperState.SyncConnected.equals(watchedEvent.getState())){
                        System.out.println("连接成功" + watchedEvent);
                        countDownLatch.countDown();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("开始连接....." );
        if (ZooKeeper.States.CONNECTING.equals(zooKeeper.getState())){
            System.out.println("连接中");
            countDownLatch.await();
        }
    }

    @Test
    public void getData() throws KeeperException, InterruptedException {
        Stat stat = new Stat();
        String data = new String(zooKeeper.getData("/zptest",true ,stat));
        System.out.println(data);
        System.out.println("stat"+stat.toString());

    }
    @Test
    public void getDataAndWatch() throws KeeperException, InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Stat stat = new Stat();
        String data = new String(zooKeeper.getData("/zptest", new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.toString());
                countDownLatch.countDown();
            }
        }, stat));
        System.out.println(data);
        System.out.println("准备监听");
        countDownLatch.await();

    }

    /**
     * 持续递归监听
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void getDataAndWatch2() throws KeeperException, InterruptedException {
        final Stat stat = new Stat();
        String data = new String(zooKeeper.getData("/zptest", new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.toString());
                try {
                    zooKeeper.getData(watchedEvent.getPath(),this,stat);//递归持续监听
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, stat));
        System.out.println(data);
        System.out.println("准备监听");
        TimeUnit.MINUTES.sleep(10);
    }
    @Test
    public  void getChrild() throws KeeperException, InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
       List<String> childrenPs = zooKeeper.getChildren("/yaru", new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.toString());
                countDownLatch.countDown();
            }
        });// ls path
        System.out.println("准备监听");
        childrenPs.stream().forEach(System.out::println);

        countDownLatch.await();
    }
    @Test
    public void createData() throws KeeperException, InterruptedException {
        List<ACL> acls = new ArrayList<>();
        int prems = ZooDefs.Perms.ALL;//Acl权限或运算
        ACL acl = new ACL(prems,new Id("world","anyone"));
        acls.add(acl);
        String res = zooKeeper.create("/zptest/DIMnb","nb2020".getBytes(),acls, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(res);
    }
    @Test
    public void setData(){
        try {
            zooKeeper.setData("/zptest", UUID.randomUUID().toString().getBytes(),11);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
