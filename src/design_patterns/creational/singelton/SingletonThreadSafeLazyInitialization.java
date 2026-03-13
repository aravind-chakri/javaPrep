package design_patterns.creational.singelton;

public class SingletonThreadSafeLazyInitialization {

    private static SingletonThreadSafeLazyInitialization instance;

    private SingletonThreadSafeLazyInitialization() {};

    public static synchronized SingletonThreadSafeLazyInitialization getInstance() {
        if(instance == null) {
            instance = new SingletonThreadSafeLazyInitialization();
        }
        return instance;
    }
}
