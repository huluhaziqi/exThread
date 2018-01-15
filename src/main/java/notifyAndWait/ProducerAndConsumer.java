package notifyAndWait;

public class ProducerAndConsumer {

    public static void main(String[] args) {
        try {
            String lock = "";
            Consumer consumer = new Consumer(lock);
            Producer producer = new Producer(lock);
            MyThread_1[] m1 = new MyThread_1[2];
            MyThread_2[] m2 = new MyThread_2[2];
            for (int i = 0; i < 2; i++) {
                m1[i] = new MyThread_1(producer);
                m1[i].setName("生产者 ：" + (i + 1));

                m2[i] = new MyThread_2(consumer);
                m2[i].setName("消费者 ：" + (i + 1));

                m1[i].start();
                m2[i].start();
            }

            Thread.sleep(5000);
            Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
            Thread.currentThread().getThreadGroup().enumerate(threads);
            for(int i = 0 ; i < threads.length; i++){
                System.out.println(threads[i].getName() + " " + threads[i].getState());
            }
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
                String value =  System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set value " + Thread.currentThread().getName() + "_" + value);
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
                System.out.println("get value " + Thread.currentThread().getName() + " " + value);
                ObjectValue.value = "";
                lock.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



