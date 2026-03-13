package generics;

public class GenericDemo {

    public static void main(String[] args) {

        ClassWithoutGeneric cwg = new ClassWithoutGeneric();
        cwg.print(8);
//        cwg.print("Aravind");  facing typecasting issues
    }
}
