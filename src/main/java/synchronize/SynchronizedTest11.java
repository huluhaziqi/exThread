package synchronize;

public class SynchronizedTest11 {
    public static void main(String[] args) {
        /**
         * 利用synchronized(class)跟将synchronized用在静态方法上是一样的，都是类锁
         */
        ServiceTest11 serviceTest11 = new ServiceTest11();
        MyThreadTest11_1 myThreadTest11_1 = new MyThreadTest11_1(serviceTest11);
        MyThreadTest11_2 myThreadTest11_2 = new MyThreadTest11_2(serviceTest11);
        myThreadTest11_1.start();
        myThreadTest11_2.start();
    }
}

class MyThreadTest11_1 extends Thread {
    private ServiceTest11 serviceTest11;

    public MyThreadTest11_1(ServiceTest11 serviceTest11) {
        this.serviceTest11 = serviceTest11;
    }

    @Override
    public void run() {
        serviceTest11.method1();
    }
}

class MyThreadTest11_2 extends Thread {
    private ServiceTest11 serviceTest11;

    public MyThreadTest11_2(ServiceTest11 serviceTest11) {
        this.serviceTest11 = serviceTest11;
    }

    @Override
    public void run() {
        serviceTest11.method2();
    }
}

class ServiceTest11 {
    public static void method1() {
        synchronized (ServiceTest11.class) {
            try {
                System.out.println("start" + " " + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("end" + " " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void method2() {
        synchronized (ServiceTest11.class) {
            try {
                System.out.println("start" + " " + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("end" + " " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}