package Account;


public class AccountingException extends Exception {
	
    public void NonExistantAccountException(String accountName) {
        	System.out.printf("Account '%s' is not in the ledger", accountName);       
    }
    
    public void PostingUnbalancedException () {
    	//Posting p;
        System.out.print("Posting was unbalanced.");
    }

}
