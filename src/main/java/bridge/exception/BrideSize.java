package bridge.exception;

public class BrideSize {
    private static final int MIN_BRIDE_SIZE = 3;
    private static final int MAX_BRIDE_SIZE = 20;

    private final String brideSizeInput;
    private final int brideSize;

    public BrideSize(String brideSizeInput) {
        this.brideSizeInput = brideSizeInput;
        isNotNumeric();
        this.brideSize = Integer.parseInt(brideSizeInput);
        checkInvalidRange();
    }

    private void isNotNumeric() {
        if (!brideSizeInput.chars().allMatch(Character::isDigit)) {
            throw new ErrorException(BrideError.IS_NOT_NUMERIC);
        }
    }

    private void checkInvalidRange() {
        if ((MIN_BRIDE_SIZE > brideSize) || (MAX_BRIDE_SIZE < brideSize)) {
            throw new ErrorException(BrideError.INVALID_RANGE);
        }
    }
}
