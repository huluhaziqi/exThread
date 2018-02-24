package Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerAndProducerForList {
    public static void main(String[] args) {
        Service20 service20 = new Service20();
        ThreadCP01[] threadCP01 = new ThreadCP01[3];
        ThreadCP02[] threadCP02 = new ThreadCP02[3];
        for(int i = 0; i < 3; i++){
            threadCP01[i] = new ThreadCP01(service20);
            threadCP01[i].start();
            threadCP02[i] = new ThreadCP02(service20);
            threadCP02[i].start();
        }
    }
}

class ThreadCP01 extends Thread {
    private Service20 service20;

    public ThreadCP01(Service20 service20) {
        this.service20 = service20;
    }

    @Override
    public void run() {
        while (true){
            service20.push();
        }
    }
}


class ThreadCP02 extends Thread {
    private Service20 service20;

    public ThreadCP02(Service20 service20) {
        this.service20 = service20;
    }

    @Override
    public void run() {
        while (true){
            service20.pop();
        }
    }
}
class Service20 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private List<Object> list = new ArrayList<>();

    public void push() {
        try {
            lock.lock();
            while (list.size() == 1) {
                System.out.println(Thread.currentThread().getName() + "await");
                condition.await();
            }
            String v = "add _" + System.currentTimeMillis();
            list.add(v);
            System.out.println(Thread.currentThread().getName() + " _push " + v);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void pop() {
        try {
            lock.lock();
            while (list.size() == 0) {
                System.out.println(Thread.currentThread().getName() + "await");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + " _pop " + list.get(0));
            list.remove(0);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}