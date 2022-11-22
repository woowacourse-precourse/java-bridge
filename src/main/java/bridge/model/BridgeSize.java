package bridge.model;

public class BridgeSize {
    private static final Integer MIN_NUMBER = 3;
    private static final Integer MAX_NUMBER = 20;
    private final Integer brideSize;

    public BridgeSize(int number) {
        validate(number);
        this.brideSize = number;
    }

    private void validate(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private boolean isValidRange(int number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }

    public Integer getBrideSize() {
        return brideSize;
    }
}
