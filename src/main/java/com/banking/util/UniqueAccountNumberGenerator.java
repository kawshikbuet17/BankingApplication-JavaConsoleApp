package main.java.com.banking.util;

public class UniqueAccountNumberGenerator {
    private static int lastAccountNumber = 0;
    public static String generateIncrementalAccountNumber() {
        lastAccountNumber++;
        return String.valueOf(lastAccountNumber);
    }

    //exception in creating account shouldn't waste account number values
    public static void decrementCount(){
        lastAccountNumber--;
    }
}