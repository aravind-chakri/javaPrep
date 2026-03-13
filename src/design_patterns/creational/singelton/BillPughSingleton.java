package design_patterns.creational.singelton;

public class BillPughSingleton {

    private BillPughSingleton() {};

    private static class Holder{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    private static BillPughSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
