package simplechain;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class SimpleChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static int difficulty = 5; // for mining

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        // loop through blockchain to check hashes
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            // compare registered hash and calculated hash
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal!");
                return false;
            }

            // compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal!");
                return false;
            }

            // check if hash is solved
            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello there, World!\n"); // TODO: remove after testing

        // first block
        Block genesisBlock = new Block("Hi, I am the first block", "0");
        blockchain.add(genesisBlock);

        System.out.println("Trying to Mine block 1... ");
        blockchain.get(0).mineBlock(difficulty);

        // second block
        Block secondBlock = new Block("Yo, I am the second block", genesisBlock.hash);
        blockchain.add(secondBlock);

        System.out.println("Trying to Mine block 2... ");
        blockchain.get(1).mineBlock(difficulty);

        // third block
        Block thirdBlock = new Block("Hey, I am the third block", secondBlock.hash);
        blockchain.add(thirdBlock);

        System.out.println("Trying to Mine block 3... ");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);

    }
}
