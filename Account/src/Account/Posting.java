package Account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Posting {
	
    private Ledger ledger;
    private Date postingDate;
    private String memo;
    //private String Entries;
    private List<Entry> entries;
    // move private Ledger l;
    //return entries = new ArrayList<Entry>();
    
    public Posting(Ledger l) {
        ledger = l;
        entries = new ArrayList<Entry>();
    }
    
    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }
    //newEntry here 
    public Entry addEntry(Account a, int amount) {
        Entry e = new Entry();
        e.setPosting(this);
        e.setAccount(a);
        e.setAmount(amount);
        return e;
    }
    
    //回傳True/Flase
    
    
}

/* 把這些寫進class裡
public Map<String, Account> getAccounts() {
	return accounts;
}

public void setAccounts(Map<String, Account> accounts) {
	this.accounts = accounts;
}

public void setPostings(ArrayList postings) {
	this.postings = postings;
}
*/
