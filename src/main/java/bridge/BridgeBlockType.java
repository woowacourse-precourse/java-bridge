package bridge;

public enum BridgeBlockType {
    UP("U", 1),
    DOWN("D", 0);

    private String block;
    private Integer inputNumber;

    BridgeBlockType(String block, Integer inputNumber) {
        this.block = block;
        this.inputNumber = inputNumber;
    }
}
