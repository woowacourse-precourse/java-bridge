package bridge.model;

import java.util.Arrays;

public enum Moving {
    UP("U"), DOWN("D");

    private static final String ERR_MOVING_FORMAT = "윗 칸은 'U', 아랫 칸은 'D'를 입력하세요. 대소문자 구별. 예시) U(O), D(O), d(X)";
    private final String inputFormat;

    Moving(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public static Moving toMoving(String format) {
        return Arrays.stream(values())
                .filter(moving -> moving.inputFormat.equals(format))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_MOVING_FORMAT));
    }
}
