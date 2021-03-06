package Account;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ledger<Entry> {
    private Map<String, Account> accounts;
    private ArrayList postings;

    public Ledger() {
        accounts = new HashMap<String, Account>();
        postings = new ArrayList();
    }

    public Account newAccount(String name, Account.Type type) {
        // Split name at ':'
        String names[] = name.split(":");
        
        // Build tree of accounts
        Account lastAccount = null;
        for (int i = 0; i < names.length; i++) {
            String accountName = names[i];

            // Fetch the existing account with names[i]
            Account a = accounts.get(accountName);

            // If account doesn't exist then create it with <names[i], type>
            if( a == null ) {
                a = new Account(accountName, type);
            }

            // Add this account to the ledger or the last account found
            if( i == 0 ) {
                accounts.put(accountName, a);
            } else {
                // Add new account to the previous account
                lastAccount.addSubAccount(a);
            }

            lastAccount = a;
        }

        return lastAccount;
    }

    public Account getAccount(String name) {
        String[] names = name.split(":");

        Account acct = null;
        for (int i = 0; i < names.length; i++) {
            String accountName = names[i];

            if (acct == null) {
                acct = accounts.get(accountName);
            } else {
                acct = acct.getSubAccount(accountName);
            }
        }

        return acct;
    }

    public <Posting> List<Posting> getPostings() {
        return postings;
    }
    
    public List<Entry> Posting () {
        Ledger ledger;
        Date postingDate;
        String memo;
        String Entries;
        List<Entry> entries;
        Ledger l;
        return entries = new ArrayList<Entry>();
    }

	public Map<String, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<String, Account> accounts) {
		this.accounts = accounts;
	}

	public void setPostings(ArrayList postings) {
		this.postings = postings;
	}


}
