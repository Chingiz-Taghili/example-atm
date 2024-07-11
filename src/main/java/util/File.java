package util;

import java.io.*;

public class File {
    public static void writeObject(Serializable object, String fileName) {
        try (FileOutputStream fout = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(object);
        } catch (IOException e) {
        }
    }

    public static Object readObject(String fileName) {
        Object obj = null;
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            obj = in.readObject();
        } finally {
            return obj;
        }
    }
}
