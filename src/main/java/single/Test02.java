package single;

public class Test02 {
    public static void main(String[] args) {
        MyThread05[] myThread05s = new MyThread05[10];
        for(MyThread05 myThread05 : myThread05s){
            myThread05 = new MyThread05();
            myThread05.start();
        }
    }
}
