package bridge.util;

public class Utils {

    public static int inputToNumber(String input){
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
