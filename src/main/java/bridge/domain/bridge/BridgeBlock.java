package bridge.domain.bridge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BridgeBlock {
    D(0), U(1);

    private final int block;

    BridgeBlock(int phaseNum) {
        this.block = phaseNum;
    }

    public static String convertType(int generateNum) {
        return Arrays.stream(BridgeBlock.values())
                .filter(value -> value.block == generateNum)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new).toString();
    }

    public static List<BridgeBlock> convertType(List<String> randomBridge) {
        return randomBridge.stream()
                .map(block -> Arrays.stream(BridgeBlock.values())
                        .filter(value -> block.equals(value.name()))
                        .findFirst()
                        .orElseThrow(IllegalAccessError::new))
                .collect(Collectors.toList());
    }
}
