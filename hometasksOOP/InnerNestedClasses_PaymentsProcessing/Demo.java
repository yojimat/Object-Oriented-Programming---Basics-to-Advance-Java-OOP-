package hometasksOOP.InnerNestedClasses_PaymentsProcessing;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Account accA = new Account(1);
        Account accB = new Account(2);

        accA.sendMoneyToAccount(accB, 100);
        accB.withdrawMoney(100);

        System.out.println("Acc A:" + Arrays.toString(accA.getTransactions()));
        System.out.println("Acc B:" + Arrays.toString(accB.getTransactions()));
    }
}
