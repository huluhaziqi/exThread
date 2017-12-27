package notifyAndWait;

public class ProducerAndConsumer {

    public static void main(String[] args) {
        try {
            String lock = "";
            Consumer consumer = new Consumer(lock);
            Producer producer = new Producer(lock);
            MyThread_1 m1 = new MyThread_1(producer);
            MyThread_2 m2 = new MyThread_2(consumer);
            m1.start();
            m2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyThread_1 extends Thread {
    private Producer producer;

    public MyThread_1(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            producer.setValue();
        }
    }
}

class MyThread_2 extends Thread {
    private Consumer consumer;

    public MyThread_2(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            consumer.getValue();
        }
    }
}


class Producer {
    private String lock;

    public Producer(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (!ObjectValue.value.equals("")) {
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set value " + value);
                ObjectValue.value = value;
                lock.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Consumer {
    private String lock;

    public Consumer(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if (ObjectValue.value.equals("")) {
                    lock.wait();
                }
                String value = ObjectValue.value;
                System.out.println("get value " + value);
                lock.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



