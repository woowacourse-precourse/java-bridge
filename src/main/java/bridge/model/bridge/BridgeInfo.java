package bridge.model.bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum BridgeInfo {
    MIN(3), MAX(20);

    private final int value;

    BridgeInfo(int val) {
        this.value = val;
    }

    public static List<String> getRange() {
        return IntStream.rangeClosed(MIN.getValue(), MAX.getValue())
                .mapToObj(String::valueOf).collect(Collectors.toList());
    }

    public int getValue() {
        return value;
    }
}
