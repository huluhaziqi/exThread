package synchronize;

public class SynchronizedTest08 {
    /**
     * 对于非this的对象锁的synchronize方法和this的synchronize方法二者运行不受影响，为异步
     * 即持有不同的对象监视器是异步的效果
     * @param args
     */
    public static void main(String[] args) {
        Service01 service01 = new Service01();
        MyThreadTest08_1 myThreadTest08_1 = new MyThreadTest08_1(service01);
        MyThreadTest08_2 myThreadTest08_2 = new MyThreadTest08_2(service01);
        myThreadTest08_1.setName("a");
        myThreadTest08_2.setName("b");
        myThreadTest08_1.start();
        myThreadTest08_2.start();
    }
}

class MyThreadTest08_1 extends Thread {
    private Service01 service01;

    public MyThreadTest08_1(Service01 service01) {
        this.service01 = service01;
    }

    @Override
    public void run() {
        service01.method();
    }
}

class MyThreadTest08_2 extends Thread {
    private Service01 service01;

    public MyThreadTest08_2(Service01 service01) {
        this.service01 = service01;
    }

    @Override
    public void run() {
        service01.method2();
    }
}

class Service01 {
    private String anyString = new String();

    public void method() {
        try {
            synchronized (anyString) {
                System.out.println(Thread.currentThread().getName() + " begin");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void method2() {
        System.out.println("method2 begin");
        System.out.println("method2 end");
    }
}
