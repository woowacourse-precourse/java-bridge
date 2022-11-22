package bridge.domain.code;

import java.util.Arrays;

public enum BridgePosition {
    UP("U", 1),
    DOWN("D", 0);

    public static final String ERROR_NOT_FOUND_POSITION_VALUE = "[ERROR] 0과 1이외의 값을 가질 수는 없습니다.";
    public static final String ERROR_DID_NOT_FOUND_CODE = "[ERROR] 입력 할 수 없는 위치값입니다.";


    private final String positionCode;
    private final Integer positionValue;


    BridgePosition(final String code, final Integer value) {
        this.positionCode = code;
        this.positionValue = value;
    }

    public static String convertValueToCode(final Integer input) {
        return Arrays.stream(BridgePosition.values())
                .filter(position -> position.positionValue.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FOUND_POSITION_VALUE))
                .positionCode;
    }

    public static BridgePosition convertCodeToPosition(final String code) {
        return Arrays.stream(BridgePosition.values())
                .filter(position -> position.positionCode.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_DID_NOT_FOUND_CODE));
    }
}
