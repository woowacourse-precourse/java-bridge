package bridge.domain;

import java.util.regex.Pattern;

import static bridge.domain.ValidationString.*;

import static bridge.domain.BridgePair.DOWN;
import static bridge.domain.BridgePair.UP;

public class Validation {
    private static final int MAX_NUMBER = 20;
    private static final int MIN_NUMBER = 3;
    //private static String BLANK_TO_MOVE_RANGE = "[U|D]";
    private static final String BLANK_TO_MOVE_RANGE = "["+UP.getValue()+"|"+DOWN.getValue()+"]";
    private static final String RETRY_OR_END_RANGE = "[R|Q]";

    public static void validateRange(int number){
        if (number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException(OVER_OR_UNDER_NUMBER_RANGE.getMessage());
        }
    }

    public static void isValidBlankToMove(String blank){
        if (!Pattern.matches(BLANK_TO_MOVE_RANGE, blank)){
            throw new IllegalArgumentException(NO_MATCH_BLANK_TO_MOVE.getMessage());
        }
    }

    public static void isValidRetryOrEnd(String retry){
        if (!Pattern.matches(RETRY_OR_END_RANGE, retry)){
            throw new IllegalArgumentException(NO_MATCH_RETRY_OR_END.getMessage());
        }
    }
}
