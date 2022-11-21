package bridge.domain.bridge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BridgeBlock {
    D(0), U(1);

    public static final String ERROR_NOT_FOUND_POSITION_VALUE = "[ERROR] D,U 중 하나만 입력할 수 있습니다.";

    private final int block;

    BridgeBlock(int phaseNum) {
        this.block = phaseNum;
    }

    public static String convertTypeString(int generateNum) {
        return Arrays.stream(BridgeBlock.values())
                .filter(value -> value.block == generateNum)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FOUND_POSITION_VALUE))
                .toString();
    }

    public static List<BridgeBlock> convertTypeList(List<String> randomBridge) {
        return randomBridge.stream()
                .map(block -> Arrays.stream(BridgeBlock.values())
                        .filter(value -> block.equals(value.name()))
                        .findFirst()
                        .orElseThrow(IllegalAccessError::new))
                .collect(Collectors.toList());
    }

    public static BridgeBlock convertTypeBlock(String readLine) {
        return Arrays.stream(BridgeBlock.values())
                .filter(block -> block.name().equals(readLine))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FOUND_POSITION_VALUE));
    }
}
