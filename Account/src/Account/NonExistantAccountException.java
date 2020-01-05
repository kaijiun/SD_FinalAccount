package Account;

public class NonExistantAccountException extends AccountingException {

    public NonExistantAccountException(String accountName) {
        super(
                String.format(
                    "Account '%s' is not in the ledger",
                    accountName
                ));
    }
}
