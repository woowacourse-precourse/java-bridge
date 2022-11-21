package bridge;

public class ValidCheck {
    private static final String BRIDGE_LENGTH_ERROR = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String WRONG_DIRECTION_ERROR = "정확히 U나 D로 입력해주세요.";
    private static final String WRONG_QUIT_ERROR = "정확히 R이나 U로 입력해주세요.";

    private static int numberFormat(String inputVal) {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(inputVal);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_ERROR);
        }
        return bridgeSize;
    }

    public static int bridgeSize(String inputVal) {
        int bridgeSize = numberFormat(inputVal);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_ERROR);
        }
        return bridgeSize;
    }

    public static void upOrDown(String inputVal) {
        if (!inputVal.equals("D") && !inputVal.equals("U")) {
            throw new IllegalArgumentException(WRONG_DIRECTION_ERROR);
        }
    }

    public static void retryOrQuit(String inputVal) {
        if (!inputVal.equals("R") && !inputVal.equals("Q")) {
            throw new IllegalArgumentException(WRONG_QUIT_ERROR);
        }
    }

}
