package exception_handling;

public class TryWithResourceDemo {

    public static void main(String[] args) {
        try(MyCustomClass customClass = new MyCustomClass()) {
            customClass.getResource();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }
}
