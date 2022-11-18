package Utils;

public class Common {
    public static int convertInputToNumber(String input) {
        int size = 0;
        try {
            size = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Error.generate(Message.NUMBER);
        }
        return size;
    }
}
