package synchronize;

public class SynchronizedTest07 {
    public static void main(String[] args) {
        ServiceTest07 serviceTest07 = new ServiceTest07();
        MyThreadTest07_1 myThreadTest07_1 = new MyThreadTest07_1(serviceTest07);
        myThreadTest07_1.setName("a");
        MyThreadTest07_2 myThreadTest07_2 = new MyThreadTest07_2(serviceTest07);
        myThreadTest07_2.setName("b");
        myThreadTest07_1.start();
        myThreadTest07_2.start();
    }
}

class MyThreadTest07_1 extends Thread {
    private ServiceTest07 serviceTest07;

    public MyThreadTest07_1(ServiceTest07 serviceTest07) {
        this.serviceTest07 = serviceTest07;
    }

    @Override
    public void run() {
        serviceTest07.method();
    }
}

class MyThreadTest07_2 extends Thread {
    private ServiceTest07 serviceTest07;

    public MyThreadTest07_2(ServiceTest07 serviceTest07) {
        this.serviceTest07 = serviceTest07;
    }

    @Override
    public void run() {
        serviceTest07.method();
    }
}

class ServiceTest07 {
    private String aString;
    private String bString;

    public void method() {
        try {
            System.out.println("begin");
            Thread.sleep(3000);
            String temp1 = "name1 " + Thread.currentThread().getName();
            System.out.println("temp1 = " + temp1);
            String temp2 = "name2 " + Thread.currentThread().getName();
            System.out.println("temp2 = " + temp2);
            synchronized (this) {
                aString = temp1;
                bString = temp2;
            }
            //此处会存在结果还没print而另一个线程已经获取对象锁并且更新数据成功打印出来
            System.out.println("result = " + aString);
            System.out.println("result = " + bString);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}