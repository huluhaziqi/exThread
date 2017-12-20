package synchronize;

public class SynchronizedTest05 {

    /**
     * 抛出异常后自动释放锁
     * @param args
     */
    public static void main(String[] args) {

        Service1 service1 = new Service1();
        MyThread myThread1 = new MyThread(service1);
        myThread1.setName("a");
        MyThread1 myThread2 = new MyThread1(service1);
        myThread2.setName("b");
        myThread1.start();
        myThread2.start();
    }
}

class MyThread extends Thread {
    private Service1 service1;

    public MyThread(Service1 service1) {
        this.service1 = service1;
    }

    @Override
    public void run() {
        service1.testMethod();
    }
}

class MyThread1 extends Thread {
    private Service1 service1;

    public MyThread1(Service1 service1) {
        this.service1 = service1;
    }

    @Override
    public void run() {
        service1.testMethod();
    }
}

class Service1 {
    public void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("threadName = " + Thread.currentThread().getName() + " time " + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                Integer.parseInt("a");
            }
        } else {
            System.out.println("name " + Thread.currentThread().getName() + " time " + System.currentTimeMillis());
        }
    }
}