package bridge;

public class StringUtil {

    public static String substrAndAddPostFix(String s) {
        s = s.substring(0, s.length() - 1);
        return s + "]";
    }

    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
