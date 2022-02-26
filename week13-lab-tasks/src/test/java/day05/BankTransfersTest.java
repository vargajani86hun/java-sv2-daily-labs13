package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankTransfersTest {

    @Test
    void testRollTransactions() {
        BankTransfers bankTransfers = new BankTransfers();
        List<TransferPerClient> transfers = bankTransfers.rollTransactions(Paths.get("src/test/resources/transfers.csv"));
        for (TransferPerClient tpc: transfers) {
            System.out.println(tpc);
        }

        assertEquals(20, transfers.size());
    }

}