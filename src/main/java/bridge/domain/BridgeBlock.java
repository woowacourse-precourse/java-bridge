package bridge.domain;

public enum BridgeBlock {
    UP("U", 1),
    DOWN("D", 0);

    private final String initial;
    private final int blockNumber;

    BridgeBlock(String initial, int blockNumber) {
        this.initial = initial;
        this.blockNumber = blockNumber;
    }

    public static String getBridgeBlock(int blockNumber) {
        for(BridgeBlock block : values()) {
            if(block.blockNumber == blockNumber) {
                return block.initial;
            }
        }
        return null;
    }

    public static boolean isUpOrDown(String direction) {
        return direction.equals(UP.initial) || direction.equals(DOWN.initial);
    }

}
