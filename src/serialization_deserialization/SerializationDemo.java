package serialization_deserialization;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        Demo obj = new Demo(1, "EPAM");
        String fileName = "file.ser";

        try(FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream obj1 = new ObjectOutputStream(fos)) {
            obj1.writeObject(obj);
            System.out.println("Object has been serialized");
        } catch (IOException i) {
            System.out.println("IOException is Caught");
        }

        Demo deserializedObject = null;

        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fis)) {
            deserializedObject = (Demo) in.readObject();
            System.out.println("Object has been deserialized");
            System.out.println("a is: " + deserializedObject.a);
            System.out.println("name is: " + deserializedObject.name);
        } catch (IOException i) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
