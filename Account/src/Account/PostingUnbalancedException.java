package Account;

public class PostingUnbalancedException extends AccountingException {

    public PostingUnbalancedException(Posting p) {
        super("Posting was unbalanced.");
    }
}