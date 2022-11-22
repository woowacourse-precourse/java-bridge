package bridge;

public class ValidCheck {

    private static int numberFormat(String inputVal) {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(inputVal);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Notice.BRIDGE_LENGTH_ERROR.getMessage());
        }
        return bridgeSize;
    }

    public static int bridgeSize(String inputVal) {
        int bridgeSize = numberFormat(inputVal);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(Notice.BRIDGE_LENGTH_ERROR.getMessage());
        }
        return bridgeSize;
    }

    public static void upOrDown(String inputVal) {
        if (!inputVal.equals("D") && !inputVal.equals("U")) {
            throw new IllegalArgumentException(Notice.WRONG_DIRECTION_ERROR.getMessage());
        }
    }

    public static void retryOrQuit(String inputVal) {
        if (!inputVal.equals("R") && !inputVal.equals("Q")) {
            throw new IllegalArgumentException(Notice.WRONG_QUIT_ERROR.getMessage());
        }
    }

}
