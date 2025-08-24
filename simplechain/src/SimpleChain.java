import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class SimpleChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) throws Exception {
        System.out.println("Hello there, World!\n"); // TODO: remove after testing

        // first block
        Block genesisBlock = new Block("Hi, I am the first block", "0");
        blockchain.add(genesisBlock);

        // second block
        Block secondBlock = new Block("Yo, I am the second block", genesisBlock.hash);
        blockchain.add(secondBlock);

        // third block
        Block thirdBlock = new Block("Hey, I am the third block", secondBlock.hash);
        blockchain.add(thirdBlock);

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);

    }
}
