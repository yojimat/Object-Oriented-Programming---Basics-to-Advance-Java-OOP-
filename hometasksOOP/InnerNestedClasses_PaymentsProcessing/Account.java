package InnerNestedClasses_PaymentsProcessing;

import java.util.Arrays;

public class Account {
    private int id;
    private Transaction[] transactions;
    private int lastIndexAdded;

    public Account(int id) {
        this.id = id;
        transactions = new Transaction[10];
    }

    public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
        if (moneyAmount <= 0 || accountTo == null)
            return;
        Transaction sendingTransaction = new Transaction(this, accountTo, moneyAmount,
                StandardAccountOperations.MONEY_TRANSFER_SEND);
        Transaction receivingTransaction = new Transaction(this, accountTo, moneyAmount,
                StandardAccountOperations.MONEY_TRANSFER_RECEIVE);

        addTransaction(sendingTransaction);
        accountTo.addTransaction(receivingTransaction);
    }

    public void withdrawMoney(double moneyAmount) {
        Transaction transaction = new Transaction(this, null, moneyAmount, StandardAccountOperations.WITHDRAW);
        addTransaction(transaction);
    }

    public Transaction[] getTransactions() {
        int nonNullTransactionsAmount = 0;
		for (Transaction transaction : transactions) {
			if (transaction != null) {
				nonNullTransactionsAmount++;
			}
		}

		Transaction[] filteredTransactions = new Transaction[nonNullTransactionsAmount];
		int index = 0;
		for (Transaction transaction : transactions) {
			if (transaction != null) {
				filteredTransactions[index++] = transaction;
			}
		}
		return filteredTransactions;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + "]";
    }

    public int getId() {
        return id;
    }

    private void addTransaction(Transaction transactionToAdd) {
        if(transactions == null) return;
        if (transactions.length <= lastIndexAdded) {
            transactions = Arrays.copyOf(transactions, transactions.length * 2);
        }
        transactions[lastIndexAdded++] = transactionToAdd;
    }

    public static class Transaction {
        private Account accountFrom;
        private Account accountTo;
        private double moneyAmount;
        private StandardAccountOperations operation;

        public Transaction(Account accountFrom, Account accountTo, double moneyAmount,
                StandardAccountOperations operation) {
            this.accountFrom = accountFrom;
            this.accountTo = accountTo;
            this.moneyAmount = moneyAmount;
            this.operation = operation;
        }

        @Override
        public String toString() {
            return "Transaction" + " from " + accountFrom + " to " + accountTo + " money" + " " + moneyAmount + " "
                    + operation;
        }

        public Account getAccountFrom() {
            return accountFrom;
        }

        public Account getAccountTo() {
            return accountFrom;
        }

        public double getMoneyAmount() {
            return moneyAmount;
        }

        public StandardAccountOperations getOperation() {
            return operation;
        }
    }
}
