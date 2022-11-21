package bridge.exception;

public class BrideSize {
    private final String brideSize;

    public BrideSize(String brideSize) {
        this.brideSize = brideSize;
    }

    private boolean isNotNumeric(String brideSize) {
        return !brideSize.chars().allMatch(Character::isDigit);
    }
}
