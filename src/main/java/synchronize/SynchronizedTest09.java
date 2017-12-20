package synchronize;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedTest09 {
    /**
     * 测试由于多线程异步导致的数据不同步，需要设置对象非this锁来确保数据的同步性
     */
    public static void main(String[] args) {
        try {
            ServiceTest09_1 serviceTest09_1 = new ServiceTest09_1();
            MythreadTes09_1 mythreadTes09_1 = new MythreadTes09_1(serviceTest09_1);
            MythreadTes09_2 mythreadTes09_2 = new MythreadTes09_2(serviceTest09_1);
            mythreadTes09_1.start();
            mythreadTes09_2.start();
            Thread.sleep(0000);
            List<Integer> list = serviceTest09_1.getList();
            System.out.println(list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MythreadTes09_1 extends Thread {
    private ServiceTest09_1 serviceTest09_1;

    public MythreadTes09_1(ServiceTest09_1 serviceTest09_1) {
        this.serviceTest09_1 = serviceTest09_1;
    }

    @Override
    public void run() {
        serviceTest09_1.add(10);
    }
}

class MythreadTes09_2 extends Thread {
    private ServiceTest09_1 serviceTest09_1;

    public MythreadTes09_2(ServiceTest09_1 serviceTest09_1) {
        this.serviceTest09_1 = serviceTest09_1;
    }

    @Override
    public void run() {
        serviceTest09_1.add(20);
    }
}

class ServiceTest09_1 {
    private List<Integer> list = new ArrayList<Integer>();

    synchronized public void add(Integer a) {
        synchronized (list) {
            try {
                if (list.size() < 1) {
                    Thread.sleep(0000);
                    list.add(a);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized int getSize() {
        return list.size();
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
