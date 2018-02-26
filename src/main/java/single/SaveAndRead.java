package single;

import java.io.*;

public class SaveAndRead {

    public static void main(String[] args) {
//        MyObject03 myObject03 = MyObject03.getInstance();
        MyObject03 myObject03 = MyObject03.getInstance();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("1.txt"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(myObject03.readResolve());
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println(myObject03.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(new File("1.txt"));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            MyObject03 myObject031 = ((MyObject03) objectInputStream.readObject());
            fileInputStream.close();
            objectInputStream.close();
            System.out.println(myObject031.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
