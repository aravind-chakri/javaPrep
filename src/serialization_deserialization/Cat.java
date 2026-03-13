package serialization_deserialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Cat implements Externalizable {
    int a;
    String name;

    public Cat(int a, String name) {
        this.a = a;
        this.name = name;
    }
    //Default no-argument constructor is must for implementing externalization
    public Cat() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(a);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        a = in.readInt();
    }
}
