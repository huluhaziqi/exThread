package single;

public class Main {

    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//        MyThread myThread3 = new MyThread();
//        MyThread myThread4 = new MyThread();
//        MyThread myThread5 = new MyThread();
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();
//        myThread4.start();
//        myThread5.start();
//        MyThread02[] myThread02s = new MyThread02[20000];
//        for(MyThread02 myThread02 : myThread02s){
//            myThread02 = new MyThread02();
//            myThread02.start();
//        }
        MyThread03[] myThread03s = new MyThread03[20000];
        for(MyThread03 myThread03 : myThread03s){
            myThread03 = new MyThread03();
            myThread03.start();
        }

    }
}
