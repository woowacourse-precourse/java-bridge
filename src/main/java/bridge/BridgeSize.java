package bridge;

public class BridgeSize {
    private final Integer brideSize;

    public BridgeSize(int number) {
        validate(number);
        this.brideSize = number;
    }

    private void validate(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidRange(int number) {
        return 3 <= number && number <= 20;
    }
}
