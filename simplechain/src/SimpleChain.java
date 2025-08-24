public class SimpleChain {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello there, World!"); // TODO: remove after testing

        // first block
        Block genesisBlock = new Block("Hi, I am the first block", "0");
        System.out.println("Hash for block 1: " + genesisBlock.hash);

        // second block
        Block secondBlock = new Block("Yo, I am the second block", genesisBlock.hash);
        System.out.println("Hash for block 2: " + secondBlock.hash);

        // third block
        Block thirdBlock = new Block("Hey, I am the third block", secondBlock.hash);
        System.out.println("Hash for block 3: " + thirdBlock.hash);

    }
}
