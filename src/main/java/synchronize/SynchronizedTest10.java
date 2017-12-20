package synchronize;

public class SynchronizedTest10 {
    public static void main(String[] args) {
        /**
         * 类锁和对象锁，二者异步运行
         */
        ServiceTest10 serviceTest10 = new ServiceTest10();
        MyThreadTest10_1 myThreadTest10_1 = new MyThreadTest10_1(serviceTest10);
        MyThreadTest10_2 myThreadTest10_2 = new MyThreadTest10_2(serviceTest10);
        MyThreadTest10_3 myThreadTest10_3 = new MyThreadTest10_3(serviceTest10);
        myThreadTest10_1.start();
        myThreadTest10_2.start();
        myThreadTest10_3.start();
    }
}

class MyThreadTest10_1 extends Thread{
    private ServiceTest10 serviceTest10;

    public MyThreadTest10_1(ServiceTest10 serviceTest10) {
        this.serviceTest10 = serviceTest10;
    }

    @Override
    public void run() {
        serviceTest10.a();
    }
}


class MyThreadTest10_2 extends Thread{
    private ServiceTest10 serviceTest10;

    public MyThreadTest10_2(ServiceTest10 serviceTest10) {
        this.serviceTest10 = serviceTest10;
    }

    @Override
    public void run() {
        serviceTest10.b();
    }
}
class MyThreadTest10_3 extends Thread{
    private ServiceTest10 serviceTest10;

    public MyThreadTest10_3(ServiceTest10 serviceTest10) {
        this.serviceTest10 = serviceTest10;
    }

    @Override
    public void run() {
        serviceTest10.c();
    }
}

class ServiceTest10 {
    synchronized  public static void a(){
        System.out.println("name = " + Thread.currentThread().getName() + "  time = " + System.currentTimeMillis() + " begin");
        System.out.println("name = " + Thread.currentThread().getName() + "  time = " + System.currentTimeMillis() + " end");
    }
    synchronized  public static void b(){
        System.out.println("name = " + Thread.currentThread().getName() + "  time = " + System.currentTimeMillis() + " begin");
        System.out.println("name = " + Thread.currentThread().getName() + "  time = " + System.currentTimeMillis() + " end");
    }
    synchronized public void c(){
        System.out.println("name = " + Thread.currentThread().getName() + "  time = " + System.currentTimeMillis() + " begin");
        System.out.println("name = " + Thread.currentThread().getName() + "  time = " + System.currentTimeMillis() + " end");
    }
}