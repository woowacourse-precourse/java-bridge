package bridge.vo;

import java.util.Arrays;

public enum BridgeAnswer {
    U(1),
    D(0);

    public static final String INVALID_NUMBER_MESSAGE = "U, D 어느 쪽에도 해당하지 않는 값입니다.";
    private final int number;

    public static String getByNumber(int number) {
        return Arrays.stream(BridgeAnswer.values())
                .filter(value -> number == value.number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_NUMBER_MESSAGE))
                // TODO: IllegalArgumentException 이 적절하지 않을 수 있다.
                .toString();
    }

    BridgeAnswer(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
