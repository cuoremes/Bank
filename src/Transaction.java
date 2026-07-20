public class Transaction {
    String frompassport;
    String topassport;
    int amount;
    boolean success;
    public Transaction(String frompassportInput, String topassportInput, int amountInput, boolean successInput){
        frompassport = frompassportInput;
        topassport = topassportInput;
        amount = amountInput;
        success = successInput;
    }
}
