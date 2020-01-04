package Test;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Test {
	
	Ledger ledger;
    Account cash;
    Account anne;
	
	@Before
    public void setUp() {
        ledger = new Ledger();
        cash = ledger.newAccount("Cash", Type.ASSET);
        anne = ledger.newAccount("Cash:Anne", Type.ASSET);
        ledger.newAccount("Dues Received", Type.INCOME);
        ledger.newAccount("Tickets Purchased", Type.EXPENSE);
    }
	
	@Test
    public void testNestedAccounts() {
        Account a;

        a = ledger.getAccount("Cash");
        assertEquals(cash, a);

        a = ledger.getAccount("Cash:Anne");
        assertEquals(anne, a);
    }
	
	@Test
    public void makePosting() throws AccountingException {
        ledger.newPosting(new Date(), "Received $10 from Anne")
                .debit("Cash:Anne", 1000)
                .credit("Dues Received", 1000)
                .post();

        int cashBalance = ledger.getAccount("Cash").getTrialBalance();
        assertEquals(-1000, cashBalance);

        int anneBalance = ledger.getAccount("Cash:Anne").getTrialBalance();
        assertEquals(-1000, anneBalance);

        int duesBalance = ledger.getAccount("Dues Received").getTrialBalance();
        assertEquals(1000, duesBalance);
    }

}
