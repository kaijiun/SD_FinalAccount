package Account;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Account<Posting> {
	
	

	public enum Type {
        ASSET(-1),
        LIABILITY(1),
        INCOME(1),
        EXPENSE(-1);

        private int normalBalanceSign;

        private Type(int normalBalanceSign) {
            this.normalBalanceSign = normalBalanceSign;
        }
        public int getNormalBalanceSign() {
            return normalBalanceSign;
        }
    }

    protected static class AccountName {
        public String firstName;
        public String restOfName;
    }
 
    private String name;
    private Type type;
    private Map<String, Account> subAccounts;

    static private AccountName toAccountName(String name) {
        AccountName acctName = new AccountName();
        acctName.restOfName = null;
        acctName.firstName = name;
        int separator = name.indexOf(':');
        if (separator > 0) {
            acctName.firstName = name.substring(0, separator);
            acctName.restOfName = name.substring(separator + 1);
        } else if (separator == 0) {
            acctName.firstName = name.substring(1);
        }
        return acctName;
    }

    public Account(String name, Type type) {
        AccountName acctName = toAccountName(name);
        
        this.name = acctName.firstName;
        this.type = type;
        this.subAccounts = new HashMap<String, Account>();

        if (acctName.restOfName != null) {
            Account sub = new Account(acctName.restOfName, type);
            subAccounts.put(sub.getName(), sub);
        }
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    void addSubAccount(Account a) {
        subAccounts.put(a.getName(), a);
    }

    public Account getSubAccount(String accountName) {
        return subAccounts.get(accountName);
    }

    public int getTrialBalance() {
        int balance = 0;
        return balance;
    }
    
}
