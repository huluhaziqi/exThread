package notifyAndWait;

import java.util.ArrayList;
import java.util.List;

public class PAndCForList {

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        ProducerForList producerForList = new ProducerForList(myStack);
        ConsumerForList consumerForList = new ConsumerForList(myStack);

        ThreadForList1 threadForList1 = new ThreadForList1(producerForList);
        ThreadForList2 threadForList2 = new ThreadForList2(consumerForList);

        threadForList1.start();
        threadForList2.start();

    }
}

class ThreadForList1 extends Thread {
    private ProducerForList producerForList;

    public ThreadForList1(ProducerForList producerForList) {
        this.producerForList = producerForList;
    }

    @Override
    public void run() {
        while (true) {
            producerForList.pushService();
        }
    }
}

class ThreadForList2 extends Thread {
    private ConsumerForList consumerForList;

    public ThreadForList2(ConsumerForList consumerForList) {
        this.consumerForList = consumerForList;
    }

    @Override
    public void run() {
        while (true) {
            consumerForList.popService();
        }
    }
}


class ProducerForList {
    private MyStack myStack;

    public ProducerForList(MyStack myStack) {
        this.myStack = myStack;
    }

    public void pushService() {
        myStack.push();
    }
}

class ConsumerForList {
    private MyStack myStack;

    public ConsumerForList(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        myStack.pop();
    }
}

class MyStack {
    private List list = new ArrayList();

    public synchronized void push() {
        try {
            if (list.size() == 1) {
                this.wait();
            }
            list.add("anyString" + Math.random());
            this.notify();
            System.out.println("push = " + list.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop() {
        String value = "";
        try {
            if (list.size() == 0) {
                this.wait();
            }
            value = (String) list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("pop=" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }

}
