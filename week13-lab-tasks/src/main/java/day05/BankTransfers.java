package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BankTransfers {
    private Map<String, TransferPerClient> users = new TreeMap<>();

    public List<TransferPerClient> rollTransactions(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                rollTransaction(values[0], values[1], Integer.parseInt(values[2]));

            }

            return Collections.unmodifiableList(users.values().stream().toList());
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!", ioe);
        }
    }

    private void decrementBalance(String id, int amount) {
        TransferPerClient source = users.computeIfAbsent(id, k -> new TransferPerClient(id));
        source.decrementBalance(amount);
    }

    private void incrementBalance(String id, int amount) {
        TransferPerClient target = users.computeIfAbsent(id, k -> new TransferPerClient(id));
        target.incrementBalance(amount);
    }

    private void rollTransaction(String sourceClientId, String targetClientId, int amount){
        decrementBalance(sourceClientId, amount);
        incrementBalance(targetClientId, amount);
    }
}
