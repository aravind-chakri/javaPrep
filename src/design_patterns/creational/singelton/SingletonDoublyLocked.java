package design_patterns.creational.singelton;

public class SingletonDoublyLocked {
    private static volatile SingletonDoublyLocked instance;

    private SingletonDoublyLocked() {};

    public static SingletonDoublyLocked getInstance() {
        if(instance == null) {
            synchronized (SingletonDoublyLocked.class) {
                if(instance == null) {
                    instance = new SingletonDoublyLocked();
                }
            }
        }
        return instance;
    }
}
