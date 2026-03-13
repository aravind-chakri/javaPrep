package serialization_deserialization;

import java.io.Serializable;

public class Demo implements Serializable {
    public int a;
    public String name;

    public Demo(int a, String name) {
        this.a = a;
        this.name = name;
    }
}
