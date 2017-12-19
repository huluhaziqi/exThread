package synchronize;

public class SychronizedTest01 {

    /**
     * 方法内的局部变量是线程安全的
     */

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        MyThread01 myThread01 = new MyThread01(myObject);
        MyThread02 myThread02 = new MyThread02(myObject);
        myThread01.start();
        myThread02.start();
    }
}

class MyThread01 extends Thread {
    private MyObject myObject;

    public MyThread01(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.add("a");
    }
}

class MyThread02 extends Thread {
    private MyObject myObject;

    public MyThread02(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.add("b");
    }
}

class MyObject {
    public void add(String username) {
        int num = 0;
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(3000);

            } else if (username.equals("b")) {
                num = 200;
                System.out.println("b set over");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(username + " num=" + num);
    }
}
