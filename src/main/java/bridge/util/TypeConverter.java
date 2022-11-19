package bridge.util;

public class TypeConverter {

    public static int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static char stringToChar(String s) {
        return s.charAt(0);
    }
}
