package serialization_deserialization;

import java.io.*;

public class TransientDemo {
    public static void printEmp(Employee e) {
        System.out.println("a: " + e.a);
        System.out.println("b: " + e.b);
        System.out.println("Name: " + e.name);
        System.out.println("age: " + e.age);
    }
    public static void main(String[] args) {
        Employee emp = new Employee(10, 1000, "Aravind", 26);
        String fileName = "file.tran";
        try(FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file)) {
            out.writeObject(emp);
            System.out.println("Object is serialized\nDetails before deserialization");
            printEmp(emp);
            emp.b = 2000;
        } catch (IOException e) {
            System.out.println("Caught IOException");
        }

        Employee employee  = null;

        try(FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file)) {
            Employee object1 = (Employee) in.readObject();
            System.out.println("Object is deserialized\nDetails after deserialization");
            printEmp(object1);
        } catch (IOException i) {
            System.out.println("Caught IOException");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException is caught");
        }

        /*
        * Explanation In the above code while deserializing the object the values of a and b has changed.
        *  The reason being a was marked as transient and b was static.
            In case of transient variables:- A variable defined with transient keyword is not serialized during serialization process.
            * This variable will be initialized with default value during deserialization. (e.g: for objects it is null, for int it is 0).
            In case of static Variables:- A variable defined with static keyword is not serialized during serialization process.
            * This variable will be loaded with current value defined in the class during deserialization.
        * */

    }
}
