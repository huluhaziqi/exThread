package single;

public class MyObject02 {

    private static MyObject02 myObject02;

    public MyObject02() {
    }

    public synchronized static MyObject02 getMyObject02() {
        try {
            if (myObject02 == null) {
                Thread.sleep(3000);
                myObject02 = new MyObject02();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject02;
    }
}
