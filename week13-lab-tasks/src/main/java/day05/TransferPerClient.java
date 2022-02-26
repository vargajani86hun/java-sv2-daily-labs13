package day05;

import java.util.Objects;

public class TransferPerClient {
    private String id;
    private int balance;
    private int numberOfTransactions;

    public TransferPerClient(String id) {
        this.id = id;
        this.balance = 0;
        this.numberOfTransactions = 0;
    }

    public String getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void decrementBalance(int amount) {
        balance -= amount;
        numberOfTransactions++;
    }

    public void incrementBalance(int amount) {
        balance += amount;
        numberOfTransactions++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransferPerClient that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%s % ,12d %5d", id, balance, numberOfTransactions);
    }
}
