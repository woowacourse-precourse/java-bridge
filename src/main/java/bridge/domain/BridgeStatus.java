package bridge.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeStatus {
    U(1),
    D(0);

    private int code;
    private static final Map<Integer, BridgeStatus> BY_CODE =
            Stream.of(values()).collect(Collectors.toMap(BridgeStatus::getCode, e -> e));

    BridgeStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static BridgeStatus findByBridgeStatus(int code) {
        return BY_CODE.get(code);
    }
}
