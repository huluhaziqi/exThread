package synchronize;

public class SynchronizedTest03 {
    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        try {
            MyThread04 myThread04 = new MyThread04();
            Thread.sleep(2000);
            myThread04.start();
            myThread04.setPriority(6);
            myThread04.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Service{
    public synchronized void service01(){
        service02();
        System.out.println("service01");
    }
    public synchronized void service02(){
        service03();
        System.out.println("service02");
    }
    public synchronized void service03(){
        System.out.println("service03");
    }

}
class MyThread04 extends Thread {
    @Override
    public void run() {
        Service service = new Service();
        service.service01();
    }
}
