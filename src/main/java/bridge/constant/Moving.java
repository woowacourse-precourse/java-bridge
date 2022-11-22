package bridge.constant;

import java.util.Arrays;

public enum Moving {
    U(1), D(0);
    final private int number;

    Moving(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Moving getNextAnswer(int randomNumber) {
        // 이 경우 사용자가 잘못된 값을 입력할 경우가 아니고 코드 상의 오류이므로 Exception을 그대로 throw하도록 처리했다.
        return Arrays.stream(Moving.values())
                .filter(moving -> moving.number == randomNumber)
                .findAny()
                .orElseThrow(()
                        -> new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_NUMBER.getString()));
    }
}
