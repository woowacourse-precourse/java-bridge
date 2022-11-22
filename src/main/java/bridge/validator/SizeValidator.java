package bridge.validator;

import static bridge.validator.ErrorConst.*;

public class SizeValidator implements Validator{
    @Override
    public void validate(String size) {
        if (!isNumber(size)) {
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
        if (!isRange(size)) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }
    private boolean isRange(String size) {
        int size_I = Integer.parseInt(size);
        if (size_I < MIN_RANGE || size_I > MAX_RANGE) return false;
        return true;
    }

    private boolean isNumber(String size) {
        for (int i = 0; i < size.length(); i++) {
            char c = size.charAt(i);
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
