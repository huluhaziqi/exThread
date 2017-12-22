package notifyAndWait;

public class test02 {
    public static void main(String[] args) {
        Object object = new Object();
        ServiceTest02 serviceTest02 = new ServiceTest02(object);
        MyThreadTest02_1 myThreadTest02_1 = new MyThreadTest02_1(serviceTest02);
        MyThreadTest02_2 myThreadTest02_2 = new MyThreadTest02_2(serviceTest02);
        myThreadTest02_1.start();
        try {
            Thread.sleep(3000);
            myThreadTest02_1.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        myThreadTest02_2.start();
    }
}

class MyThreadTest02_1 extends Thread {
    private ServiceTest02 serviceTest02;
    public MyThreadTest02_1(ServiceTest02 serviceTest02){
        this.serviceTest02 = serviceTest02;
    }
    @Override
    public void run() {
        serviceTest02.method1();
    }
}
class MyThreadTest02_2 extends Thread {
    private ServiceTest02 serviceTest02;
    public MyThreadTest02_2(ServiceTest02 serviceTest02){
        this.serviceTest02 = serviceTest02;
    }
    @Override
    public void run() {
        serviceTest02.method2();
    }
}

class ServiceTest02 {
    private Object lock;

    public ServiceTest02(Object lock) {
        this.lock = lock;
    }
    public void method1() {
        synchronized (lock) {
            System.out.println("name " + Thread.currentThread().getName() + "  start of method1 ");
            try {
                lock.wait();
                System.out.println("释放锁 time = " + System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("name " + Thread.currentThread().getName() + " end of method1");
        }
    }
    public void method2() {
        synchronized (lock) {
            System.out.println("拿到锁 time = " + System.currentTimeMillis());
            System.out.println("name " + Thread.currentThread().getName() + " start of method2");
				lock.notify();
            System.out.println("name " + Thread.currentThread().getName() + " end of method2");
        }
    }
}