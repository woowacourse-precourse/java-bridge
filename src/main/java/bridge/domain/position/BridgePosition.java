package bridge.domain.position;

import java.util.Arrays;

public enum BridgePosition {
    UP("U", 1),
    DOWN("D", 0);

    public static final String ERROR_NOT_FOUND_POSITION_VALUE = "[ERROR] 0과 1이외의 값을 가질 수는 없습니다.";
    private final String positionCode;
    private final Integer positionValue;


    BridgePosition(final String code, final Integer value) {
        this.positionCode = code;
        this.positionValue = value;
    }

    public static String convertValueToCode(Integer input) {
        return Arrays.stream(BridgePosition.values())
                .filter(position -> position.positionValue.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FOUND_POSITION_VALUE))
                .positionCode;
    }
}
