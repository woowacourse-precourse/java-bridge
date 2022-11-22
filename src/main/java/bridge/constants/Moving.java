package bridge.constants;

import java.util.Arrays;

public enum Moving {
    U(1),
    D(0);

    Moving(int number) {
        this.number = number;
    }

    private static final String NUMBER_ERROR = "[ERROR] 숫자 생성은 0과 1만 가능합니다";
    final int number;


    public static Moving getMovingFromNumber(int number) {
        return Arrays.stream(Moving.values())
                .filter(move -> move.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NUMBER_ERROR));
    }
}
