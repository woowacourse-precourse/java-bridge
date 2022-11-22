package bridge;

import java.util.Arrays;

import static bridge.Application.ERROR_PREFIX;

public enum DIRECTION {
    UP("U"), DOWN("D");

    private final String value;

    DIRECTION(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DIRECTION toEnum(String value) {
        return Arrays.stream(DIRECTION.values())
                .filter(direction -> direction.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + String.format("%s 혹은 %s 로 입력해야 합니다.", UP.getValue(), DOWN.getValue())));
    }
}
