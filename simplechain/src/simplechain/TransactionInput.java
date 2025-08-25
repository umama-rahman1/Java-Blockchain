package simplechain;

public class TransactionInput {

    public String transactionOutputId;
    public TransactionOutput UTXO; // Unspent TransactionS

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }

}
