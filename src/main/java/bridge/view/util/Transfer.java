package bridge.view.util;

public class Transfer {

    private static final String WARM_NUMBER_FORMAT = "[ERROR] 숫자만 입력할 수 있습니다.";

    public static int toNumber(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WARM_NUMBER_FORMAT);
        }
    }
}
