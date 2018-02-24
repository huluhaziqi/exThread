package single;

public class MyObject {

    private static MyObject myObject = new MyObject();
    public MyObject() {

    }

    public static MyObject getMyObject() {
        return myObject;
    }
}
