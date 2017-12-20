package synchronize;

public class SynchronizedTest12 {
    public static void main(String[] args) {
        /**
         * JVM对于String有缓存
         * 因此synchronized一般不适用String
         * 使用new Object作为对象
         */
        ServiceTest12 serviceTest12 = new ServiceTest12();
        MyThreadTest12_1 myThreadTest12_1 = new MyThreadTest12_1(serviceTest12);
        MyThreadTest12_1 myThreadTest12_2 = new MyThreadTest12_1(serviceTest12);
        myThreadTest12_1.start();
        myThreadTest12_2.start();
    }
}

class MyThreadTest12_1 extends Thread {
    private ServiceTest12 serviceTest12;

    public MyThreadTest12_1(ServiceTest12 serviceTest12) {
        this.serviceTest12 = serviceTest12;
    }

    @Override
    public void run() {
        serviceTest12.method(new Object());
    }
}

class MyThreadTest12_2 extends Thread {
    private ServiceTest12 serviceTest12;

    public MyThreadTest12_2(ServiceTest12 serviceTest12) {
        this.serviceTest12 = serviceTest12;
    }

    @Override
    public void run() {
        serviceTest12.method(new Object());
    }
}

class ServiceTest12 {
    public void method(Object a) {
        synchronized (a) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + a);
            }
        }
    }
}

