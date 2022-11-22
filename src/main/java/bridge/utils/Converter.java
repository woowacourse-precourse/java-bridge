package bridge.utils;

public class Converter {

    public static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(nfe.getMessage());
        }
    }
}
