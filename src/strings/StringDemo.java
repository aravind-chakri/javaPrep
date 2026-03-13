package strings;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class StringDemo {
    public static void main(String[] args) {
        /*
        * String is an immutable sequence of characters. Upon modification,
        * it creates a new string every time.
        * Strings are thread safe by default;
        * */
        String s = "Hello";
        s.concat("World");
        // strings are immutable and every time we modify the existing string we create new String
        System.out.println(s);
        /*
        * we created string object with value "Hello" and concatinated it with value "World"
        * but as String create new objects upon modification, the value of s is unchanged
        * */



    }

}
