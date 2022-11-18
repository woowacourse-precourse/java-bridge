package bridge.vo;

import java.util.Arrays;

public enum Moving {
    U(1),
    D(0);

    private final int number;

    Moving(int number) {
        this.number = number;
    }

    public static String getValueByNumber(int number) {
        return Arrays.stream(Moving.values())
                .filter(value -> number == value.number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("0 또는 1만 U와 D로 변환할 수 있습니다."))
                .toString();
    }

}
