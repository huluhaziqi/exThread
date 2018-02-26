package single;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class MyObject03 implements Serializable {
    private static final long serialVersionUID = 888L;

    public MyObject03() {

    }

    public static MyObject03 getInstance() {
        return MyObjectHandler.myObject03;
    }

    private static class MyObjectHandler {
        private static final MyObject03 myObject03 = new MyObject03();
    }

    protected Object readResolve() throws ObjectStreamException {
        return MyObjectHandler.myObject03;
    }

}
