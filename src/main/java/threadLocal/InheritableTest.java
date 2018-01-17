package threadLocal;

public class InheritableTest extends InheritableThreadLocal {

    @Override
    protected Object initialValue() {
        return System.currentTimeMillis();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + " _add";
    }
}
