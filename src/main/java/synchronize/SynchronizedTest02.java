package synchronize;

public class SynchronizedTest02 {
    public static void main(String[] args) {
        MyObject1 myObject1 = new MyObject1("a");
        MyThread10 myThread10 = new MyThread10(myObject1);
        MyThread11 myThread11 = new MyThread11(myObject1);
        myThread10.start();
        myThread11.start();
        myObject1.print();
        myObject1.print();
    }
}

class MyObject1 {
    private int count = 0;
    private String name = "myObject";

    public MyObject1(String name) {
        this.name = name;
    }

    public synchronized void add(String username) {
        try {
            if (username.equals("a")) {
                count = 100;
                Thread.sleep(2000);
            } else if (username.equals("b")) {
                count = 200;
                Thread.sleep(2000);
            }
            System.out.println(username + " count = " + count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public synchronized void print(){
        System.out.println("count = " + count + " name = " + name);

    }
}

class MyThread10 extends Thread {

    private MyObject1 myObject1;

    public MyThread10(MyObject1 myObject1) {
        this.myObject1 = myObject1;
    }

    @Override
    public void run() {
        myObject1.add("a");
    }
}
class MyThread11 extends Thread {

    private MyObject1 myObject1;

    public MyThread11(MyObject1 myObject1) {
        this.myObject1 = myObject1;
    }

    @Override
    public void run() {
        myObject1.add("b");
    }
}
