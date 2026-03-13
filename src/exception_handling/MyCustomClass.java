package exception_handling;

public class MyCustomClass implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Resource is closed");
    }

    public void getResource() {
        System.out.println("MyCustomClass resource is active");
    }
}
