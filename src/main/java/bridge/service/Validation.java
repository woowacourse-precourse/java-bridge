package bridge.service;

import java.util.regex.Pattern;

public class Validation {
    private final static String ERROR = "[ERROR] ";

    public static void isNull(Object s) {
        if(s==null) {
            throw new NullPointerException(ERROR + "값이 비어 있습니다.");
        }
    }

    public static void isNumber(String s) {
        isNull(s);
        if (!Pattern.matches("^[0-9]*$", s) || s.length()==0) {
            throw new IllegalArgumentException(ERROR + "숫자 형식이 아닙니다.");
        }
    }

    public static void isUpOrDown(String s) {
        isNull(s);
        if(!"UD".contains(s) || s.length()!=1) {
            throw new IllegalArgumentException(ERROR + "U 또는 D가 아닙니다.");
        }
    }

    public static void isRestartOrQuit(String s) {
        isNull(s);
        if(!"RQ".contains(s) || s.length()!=1) {
            throw new IllegalArgumentException(ERROR + "R 또는 Q가 아닙니다.");
        }
    }
}
