package bridge.util;

public class Converter {

    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";

    public int convertToInt(String s) {
        return Integer.parseInt(s);
    }

    public String convertBooleanToString(boolean success) {
        if (success) {
            return SUCCESS;
        }
        return FAILURE;
    }

}