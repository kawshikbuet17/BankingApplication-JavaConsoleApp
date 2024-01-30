package main.java.com.singleton;
public class BankSingleton {
    private static BankSingleton instance;
    private final Bank bank;

    private BankSingleton() {
        this.bank = new BankImpl();
    }

    public static BankSingleton getInstance() {
        if (instance == null) {
            synchronized (BankSingleton.class) {
                if (instance == null) {
                    instance = new BankSingleton();
                }
            }
        }
        return instance;
    }

    public Bank getBank() {
        return bank;
    }
}
