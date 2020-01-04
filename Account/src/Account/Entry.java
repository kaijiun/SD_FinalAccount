package Account;

import java.util.Map;

public class Entry {
	//public static Ledger Entry;
	private Account account;
	private int amount;
	private Posting posting;

	public void Entry () {
	    Posting posting;
	    Account account;
	    int amount;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
        this.account = account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Posting getPosting() {
        return posting;
    }

    public void setPosting(Posting posting) {
        this.posting = posting;
    }

    /*
    public Map<String, Account> getSubAccounts() {
		return subAccounts;
	}

	public void setSubAccounts(Map<String, Account> subAccounts) {
		this.subAccounts = subAccounts;
	}
	*/

}
