package synchronize;

public class SynchronizedTest06 {

    public static void main(String[] args) {
//        A a = new A();
//        MyThread111 myThread111 = new MyThread111(a);
//        myThread111.setName("a");
//        MyThread112 myThread112 = new MyThread112(a);
//        myThread111.setName("b");
//        myThread111.start();
//        myThread112.start();

        B b = new B();
        MyThread111 myThread1111 = new MyThread111(b);
        myThread1111.setName("aa");
        MyThread112 myThread1121 = new MyThread112(b);
        myThread1121.setName("bb");
        myThread1111.start();
        myThread1121.start();
    }
}

class MyThread111 extends Thread {
    private ServiceTestExtend serviceTestExtend;

    public MyThread111(ServiceTestExtend serviceTestExtend) {
        this.serviceTestExtend = serviceTestExtend;
    }

    @Override
    public void run() {
        serviceTestExtend.method();
    }
}

class MyThread112 extends Thread {
    private ServiceTestExtend serviceTestExtend;

    public MyThread112(ServiceTestExtend serviceTestExtend) {
        this.serviceTestExtend = serviceTestExtend;
    }

    @Override
    public void run() {
        serviceTestExtend.method();
    }
}

class ServiceTestExtend {
    public synchronized void method() {
        try {
            System.out.println("begin name = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("end name = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class A extends ServiceTestExtend{
    @Override
    public synchronized void method() {
        try {
            System.out.println("begin name = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("end name = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            super.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class B extends ServiceTestExtend{
    @Override
    public void method() {
        try {
            System.out.println("begin name = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("end name = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            super.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}