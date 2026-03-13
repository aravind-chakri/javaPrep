package strings;

public class StringBufferDemo {
    public static void main(String[] args) {
        /*
        * StringBuffer works same as StringBuffer, but provides thread safety and it's synchronized.
        * Means only one thread can access and modify this at a time.
        * */
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println(sb);
        sb.append(".");
        System.out.println(sb);
    }
}
