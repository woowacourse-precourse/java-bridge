package bridge.validator;

import java.util.regex.Pattern;

import static bridge.validator.ErrorMessage.*;

public class BridgeSizeValidator {
    public static final Pattern pattern = Pattern.compile("[0-9]+");

    public static Integer runBridgeSizeValidator(String sizeStr) {
        int size;
        if (isNotConsistNumber(sizeStr)) {
            throw new IllegalArgumentException(NOT_NUMBER.getErrorMessage());
        }
        size = Integer.parseInt(sizeStr);
        if (isNotInRange3To20(size)) {
            throw new IllegalArgumentException(NOT_IN_RANGE_3_TO_20.getErrorMessage());
        }

        return size;
    }

    private static boolean isNotInRange3To20(int size) {
        return !(3 <= size && size <= 20);
    }

    private static boolean isNotConsistNumber(String sizeStr) {
        return !pattern.matcher(sizeStr).matches();
    }
}
