package exception_handling;

public class MultiExceptionCatch {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        try {
            int result = a/b;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw e;
        }
    }
}
