package Account;

public abstract class AccountingException {
	private Account account;
	
	public AccountingException(Throwable cause) {
        super();
    }

    public AccountingException(String message, Throwable cause) {
        super();
    }

    public AccountingException(String message) {
        super();
    }

    public AccountingException() {
    }

}
