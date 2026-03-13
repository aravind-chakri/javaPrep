package exception_handling;

public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            System.out.println("Printing finally block");
        }
    }
}
