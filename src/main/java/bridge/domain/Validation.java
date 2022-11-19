package bridge.domain;

import java.util.regex.Pattern;

import static bridge.domain.ValidationString.*;

public class Validation {
    private static int MAX_NUMBER = 20;
    private static int MIN_NUMBER = 3;

    public static void validateRange(int number){
        if (number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException(OVER_OR_UNDER_NUMBER_RANGE.getMessage());
        }
    }

}
