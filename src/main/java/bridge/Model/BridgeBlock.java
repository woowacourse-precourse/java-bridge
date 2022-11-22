package bridge.Model;

import java.util.Arrays;



public enum BridgeBlock {
    UP("U", 1),
    DOWN("D", 0);


    private final String blockIdentifier;
    private final int blockNumber;


    BridgeBlock(String blockIdentifier, int blockNumber) {
        this.blockIdentifier = blockIdentifier;
        this.blockNumber = blockNumber;
    }


    public static String getBlockIdentifier(int blockNumber) {
        return Arrays.stream(BridgeBlock.values())
                .filter(block -> block.blockNumber == blockNumber)
                .findAny()
                .get()
                .blockIdentifier;
    }
}
