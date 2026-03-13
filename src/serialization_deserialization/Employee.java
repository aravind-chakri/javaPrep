package serialization_deserialization;

import java.io.Serializable;

public class Employee implements Serializable {
    public static final long serialVersionUID = 12343232L;
    transient int a;
    static int b;
    String name;
    int age;

    public Employee(int a, int b, String name, int age) {
        this.a = a;
        this.b = b;
        this.name = name;
        this.age = age;
    }

}
