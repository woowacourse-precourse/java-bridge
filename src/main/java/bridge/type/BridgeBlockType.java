package bridge.type;

import java.util.Arrays;

public enum BridgeBlockType {
    UP("U", 1),
    DOWN("D", 0),
    EMPTY("", -1);

    private String block;
    private int inputNumber;

    BridgeBlockType(String block, int inputNumber) {
        this.block = block;
        this.inputNumber = inputNumber;
    }

    public String getBlock() {
        return block;
    }

    public static String getBlockByInputNumber(int inputNumber) {
        return Arrays.stream(BridgeBlockType.values())
                .filter(blockType -> blockType.inputNumber == inputNumber)
                .findFirst()
                .orElse(EMPTY)
                .getBlock();
    }
}
