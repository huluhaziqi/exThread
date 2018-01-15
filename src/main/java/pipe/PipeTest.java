package pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeTest {

    public static void main(String[] args) {
        try {
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            pipedInputStream.connect(pipedOutputStream);
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            MyThread1 myThread1 = new MyThread1(writeData,pipedOutputStream);
            MyThread2 myThread2 = new MyThread2(readData,pipedInputStream);
            myThread1.start();
            Thread.sleep(2000);
            myThread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyThread1 extends Thread {
    private WriteData writeData;

    private PipedOutputStream out;

    public MyThread1(WriteData writeData, PipedOutputStream out) {
        this.writeData = writeData;
        this.out = out;
    }

    @Override
    public void run() {
        writeData.writeMethod(out);
    }
}

class MyThread2 extends Thread {

    private ReadData readData;

    private PipedInputStream in;

    public MyThread2(ReadData readData, PipedInputStream in) {
        this.readData = readData;
        this.in = in;
    }

    @Override
    public void run() {
        readData.readMethod(in);
    }
}


class WriteData {
    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write begin:");
            for (int i = 0; i < 300; i++) {
                String outData = " " + (i + 1);
                System.out.println(outData);
                out.write(outData.getBytes());
            }
            System.out.println("write end!");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadData {
    public void readMethod(PipedInputStream in) {
        try {
            System.out.println("read begin:");
            byte[] array = new byte[300];
            int len = in.read(array);
            while (len != -1) {
                String newData = new String(array, 0, len);
                System.out.println(newData);
                len = in.read(array);
            }
            System.out.println("read end!");
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
