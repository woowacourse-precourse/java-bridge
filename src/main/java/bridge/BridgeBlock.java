package bridge;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BridgeBlock {
    U(1), D(0);

    private final int blockValue;

    BridgeBlock(int blockValue) {
        this.blockValue = blockValue;
    }

    public static BridgeBlock of(int blockValue) {
        return Arrays.stream(BridgeBlock.values())
                .filter(bridgeBlock -> bridgeBlock.blockValue == blockValue)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("[ERROR] 다리 무작위 값은 0 또는 1이어야 합니다"));
    }

    public static String getBlockName(String safeBlock) {
        try {
            BridgeBlock bridgeBlock = BridgeBlock.valueOf(safeBlock);
            return bridgeBlock.name();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D여야 합니다");
        }
    }
}
