package bridge;

public class BridgeSize {
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
        return 3 <= number && number <= 20;
    }

    public Integer getBrideSize() {
        return brideSize;
    }
}
