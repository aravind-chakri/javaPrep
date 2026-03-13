package software_design_principles.kiss;

public class GoodCode {
    public static void main(String[] args) {
        System.out.println("is Even: " + isEven(7));
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /*
    The above code is considered good because it is:
        Simple, one-liner solution.
        Easy to read and understand.
        Follows the KISS principle by avoiding overengineering.
     */
}
