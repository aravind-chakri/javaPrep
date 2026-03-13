package serialization_deserialization;

import java.io.*;

public class ExternalizationDemo {
    public static void main(String[] args) {
        Cat c = new Cat(2, "Tom");
        String fileName = "file.txt";

        try(FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file)) {
            out.writeObject(c);
            System.out.println("Object is serialized using externalization");
        } catch (IOException e) {
            System.out.println("IOException is caught");
        }

        Cat desObj = null;

        try(FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file)) {
            desObj = (Cat) in.readObject();
            System.out.println("Object is deserialized using externalization");
            System.out.println("a: " + desObj.a);
            System.out.println("Name: " + desObj.name);
        } catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException is caught");
        } catch (IOException e) {
            System.out.println("IOException is caught");
        }
    }
}
