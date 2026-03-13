package design_patterns.creational.singelton;

public class SingletonEagerInitialization {
    private static final SingletonEagerInitialization INSTANCE = new SingletonEagerInitialization();

    private SingletonEagerInitialization() {};

    public static SingletonEagerInitialization getInstance() {
        return INSTANCE;
    }
}
