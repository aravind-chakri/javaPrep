package serialization_deserialization;

import java.io.Serializable;

public class Dog implements Serializable {
    int a = 10;
    transient final int b = 20;

    /*
    * Final variables are serialized by their value directly.
      Declaring a final variable as transient has no use because the compiler replaces
    * final variables with their literal values in the bytecode.
    * */
}
