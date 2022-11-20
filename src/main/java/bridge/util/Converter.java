package bridge.util;

public class Converter {
    public static final String intConvertFailMessage = "를 숫자로 변환할 수 없습니다.";
    public static int stringToInt(String str) {
        try {
            int number = Integer.parseInt(str);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(str + intConvertFailMessage);
        }
    }
    public static boolean retryQuitToBoolean(String retryQuit) {
        if(retryQuit.equals("R")) return true;
        return false;
    }
}
