package bridge.utils;

import java.util.regex.Pattern;


public class Validation {
    private final static String ERROR = "[ERROR] ";
    private final static String BLANK_MESSAGE = "값이 비어 있습니다.";
    private final static String NOT_NUMBER_MESSAGE = "숫자 형식이 아닙니다.";
    private final static String RANGE_MESSAGE = "다리 길이는 %d부터 %d 사이의 숫자여야 합니다.";
    private final static String OBSERVANCE_MESSAGE = "%s에 들어있지 않습니다.";


    public static void isNull(Object s) {
        if(s==null) {
            throw new NullPointerException(ERROR + BLANK_MESSAGE);
        }
    }

    public static void isNumber(String s) {
        isNull(s);
        if (!Pattern.matches("^[0-9]*$", s) || s.length()==0) {
            throw new IllegalArgumentException(ERROR + NOT_NUMBER_MESSAGE);
        }
    }

    public static void isInRange(int lower, int x, int upper) {
        if (!(lower <= x && x<= upper)){
            throw new IllegalArgumentException(ERROR + String.format(RANGE_MESSAGE, lower, upper));
        }
    }

    public static void isContain(String stand, String s) {
        isNull(s);
        if(!stand.contains(s) || s.length()!=1) {
            throw new IllegalArgumentException(ERROR + String.format(OBSERVANCE_MESSAGE, stand));
        }
    }
}