package notifyAndWait;

import java.util.ArrayList;
import java.util.List;

public class PAndCForList {

    public static void main(String[] args) {
//
//        MyStack myStack = new MyStack();
//        ProducerForList producerForList = new ProducerForList(myStack);
//        ConsumerForList consumerForList1 = new ConsumerForList(myStack);
//        ConsumerForList consumerForList2 = new ConsumerForList(myStack);
//        ConsumerForList consumerForList3 = new ConsumerForList(myStack);
//        ConsumerForList consumerForList4 = new ConsumerForList(myStack);
//        ConsumerForList consumerForList5 = new ConsumerForList(myStack);
//
//        ThreadForList1 threadForList1 = new ThreadForList1(producerForList);
//        threadForList1.setName("生产者 1");
//        ThreadForList2 threadForList21 = new ThreadForList2(consumerForList1);
//        threadForList21.setName("消费者 1");
//        ThreadForList2 threadForList22 = new ThreadForList2(consumerForList2);
//        threadForList22.setName("消费者 2");
//        ThreadForList2 threadForList23 = new ThreadForList2(consumerForList3);
//        threadForList23.setName("消费者 3");
//        ThreadForList2 threadForList24 = new ThreadForList2(consumerForList4);
//        threadForList24.setName("消费者 4");
//        ThreadForList2 threadForList25 = new ThreadForList2(consumerForList5);
//        threadForList25.setName("消费者 5");
//
//        threadForList1.start();
//        threadForList21.start();
//        threadForList22.start();
//        threadForList23.start();
//        threadForList24.start();
//        threadForList25.start();

        MyStack myStack = new MyStack();
        ProducerForList producerForList = new ProducerForList(myStack);
        ConsumerForList consumerForList1 = new ConsumerForList(myStack);

        ThreadForList1 threadForList1 = new ThreadForList1(producerForList);
        threadForList1.setName("生产者 1");
        ThreadForList1 threadForList2 = new ThreadForList1(producerForList);
        threadForList1.setName("生产者 2");
        ThreadForList1 threadForList3= new ThreadForList1(producerForList);
        threadForList1.setName("生产者 3");
        ThreadForList1 threadForList4 = new ThreadForList1(producerForList);
        threadForList1.setName("生产者 4");
        ThreadForList1 threadForList5 = new ThreadForList1(producerForList);
        threadForList1.setName("生产者 5");
        ThreadForList2 threadForList21 = new ThreadForList2(consumerForList1);
        threadForList21.setName("消费者 1");

        threadForList1.start();
        threadForList2.start();
        threadForList3.start();
        threadForList4.start();
        threadForList5.start();
        threadForList21.start();
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
                System.out.println("阻塞了" + Thread.currentThread().getName());
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
                System.out.println("阻塞了" + Thread.currentThread().getName());
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
