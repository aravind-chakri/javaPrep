package memory_management;

public class MemoryManagement {
    public static void main(String[] args) {
        int primitiveVariable = 29;
        String StringLiteral = "Hello";
        Person person = new Person(24, "Yashwant");
        MemoryManagement memoryManagement = new MemoryManagement();
       memoryManagement.memoryManagementTest(person);
    }

    private void memoryManagementTest(Person obj) {
        Person person = obj;
        String literal = "Hello";
        String object = new String("Hello World");
    }
}
