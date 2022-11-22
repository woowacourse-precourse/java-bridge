package bridge.view;

public class SizeValidator implements Validator{

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    @Override
    public void validate(String str) {
        validateIsNumber(str);
        validateIsInRange(str);
    }

    private void validateIsNumber(String str) {
        String regex = "[0-9]+";
        if (!str.matches(regex)) {
            throw new IllegalArgumentException(ViewError.PREFIX +
                    ViewError.ERROR_NUMBER);
        }
    }

    private void validateIsInRange(String str) {
        int val = Integer.parseInt(str);
        if (val > MAX_SIZE || val < MIN_SIZE) {
            throw new IllegalArgumentException(ViewError.PREFIX +
                    ViewError.ERROR_RANGE);
        }
    }
}
