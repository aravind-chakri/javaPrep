package strings;

public class StringBuilderDemo {
    public static void main(String[] args) {
        /*
        * StringBuilder is a sequence of mutable characters. It allows modification of strings
        * without modification of new String objects.
        * */
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);
        sb.append(".");
        System.out.println(sb);
    }
}
