package bridge.util;

public class Validator {

    private static final String IS_DIGIT_ERROR = "3이상 20이하 숫자만 입력 가능합니다.";
    private static final String BRIDGE_SIZE_ERROR = "다리길이는 3이상 20이하만 가능합니다.";

    public int canCreateBridge(String number) {
        int changeNumber = toInt(number);
        checkCreateBridgeSize(changeNumber);
        return changeNumber;
    }

    public int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(IS_DIGIT_ERROR);
        }
    }

    public void checkCreateBridgeSize(int number) {
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }

}
