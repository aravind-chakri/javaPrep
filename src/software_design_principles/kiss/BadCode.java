package software_design_principles.kiss;

public class BadCode {
    public static void main(String[] args) {
        System.out.println("is Even: " + isEven(7));
    }

    private static boolean isEven(int number) {
        boolean isEven;

        if(number % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }
        return isEven;
    }

    /*
    The above code is considered bad because it:
        Uses extra variables.
        Adds unnecessary if-else logic.
        Makes the code longer and harder to follow.
    */
}
