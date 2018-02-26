package single;

public class MyThread05 extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(SingleTon04.getConnection().hashCode());
            System.out.println(this.hashCode());
        }
    }
}
