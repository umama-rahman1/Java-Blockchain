package simplechain;

import java.security.PublicKey;

public class TransactionOutput {
    public String id;
    public PublicKey reciepient; // new owner of coin
    public float value; // amount of coins they own
    public String parentTransactionId; // id of transaction this output was created in

    // Constructor
    public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
        this.reciepient = reciepient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = StringUtil
                .applySha256(StringUtil.getStringFromKey(reciepient) + Float.toString(value) + parentTransactionId);
    }

    public boolean isMine(PublicKey publicKey) {
        return (publicKey == reciepient);
    }
}
