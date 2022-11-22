package bridge.util;

public enum BridgeBlock {
    BRIDGE_START("["),
    BRIDGE_END("]"),
    BLOCK_DIVISOR("|"),
    NOT_MOVED("   "),
    SUCCESS_MOVED(" O "),
    FAIL_MOVED(" X ");

    private final String block;

    BridgeBlock(String block) {
        this.block = block;
    }

    public String getBlock() {
        return block;
    }
}
