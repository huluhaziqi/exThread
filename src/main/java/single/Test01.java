package single;

public class Test01 {

    public static void main(String[] args) {
        MyThread04[] myThread04s = new MyThread04[10];
        for(MyThread04 myThread04 : myThread04s){
            myThread04 = new MyThread04();
            myThread04.start();
        }
    }
}
