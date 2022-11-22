package bridge;

public class Utils {

    public static int parseInt(String input) {
        try {
            int num = Integer.parseInt(input);
            return num;
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.INPUT_IS_NOT_NUM.getMessage());
        }
    }
}
