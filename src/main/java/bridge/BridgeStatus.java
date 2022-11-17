package bridge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BridgeStatus {

    UP("U"), DOWN("D");

    private final String mark;

    BridgeStatus(String mark) {
        this.mark = mark;
    }

    public static List<BridgeStatus> of(List<String> marks) {
        return marks.stream()
                .map(BridgeStatus::of)
                .collect(Collectors.toList());
    }

    private static BridgeStatus of(String mark) {
        return Arrays.stream(BridgeStatus.values())
                .filter(bridgeStatus -> bridgeStatus.isEqualMark(mark))
                .findFirst()
                .orElseThrow();
    }

    private boolean isEqualMark(String mark) {
        return this.mark.equals(mark);
    }
}
