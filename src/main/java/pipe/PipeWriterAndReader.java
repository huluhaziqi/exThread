package pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeWriterAndReader {

    public static void main(String[] args) {
        try {
            Write write = new Write();
            Read read = new Read();
            PipedReader pipedReader = new PipedReader();
            PipedWriter pipedWriter = new PipedWriter();
            pipedReader.connect(pipedWriter);
            Thread01 thread01 = new Thread01(write,pipedWriter);
            Thread02 thread02 = new Thread02(read,pipedReader);
            thread01.start();
            Thread.sleep(3000);
            thread02.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Thread01 extends Thread {
    private Write write;

    private PipedWriter pipedWriter;

    public Thread01(Write write, PipedWriter pipedWriter) {
        this.write = write;
        this.pipedWriter = pipedWriter;
    }

    @Override
    public void run() {
        write.writeMethod(pipedWriter);
    }

}

class Thread02 extends Thread {
    private Read read;

    private PipedReader pipedReader;

    public Thread02(Read read, PipedReader pipedReader) {
        this.read = read;
        this.pipedReader = pipedReader;
    }

    @Override
    public void run() {
        read.readMethod(pipedReader);
    }

}

class Write {

    public void writeMethod(PipedWriter pipedWriter) {
        try {
            System.out.println("write start :");
            for (int i = 0; i < 300; i++) {
                String data = " " + (i + 1);
                pipedWriter.write(data);
                System.out.print(data);
            }
            System.out.println();
            pipedWriter.close();
            System.out.println("write end !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Read {
    public void readMethod(PipedReader pipedReader) {
        try {
            System.out.println("read start :");
            char[] arrr = new char[20];
            int len = pipedReader.read(arrr);
            while (len != -1) {
                String data = new String(arrr, 0, len);
                System.out.print(data);
                len = pipedReader.read(arrr);
            }
            pipedReader.close();
            System.out.println("read end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
