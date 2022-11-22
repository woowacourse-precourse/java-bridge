package Exception;

import bridge.BridgeDirection;

import java.util.regex.Pattern;

public class CheckException {
    private static final int MINIMUM_BRIDGESIZE = 3;
    private static final int MAXIMUM_BRIDGESIZE = 20;
    private static final String NUMERICAL_REGULAREXPRESSION = "^[0-9]*$";
    private static final String OUTOFSIZERANGE_ERRORMESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String NOTNUMBER_ERRORMESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String INVALIDMOVING_ERRORMESSAGE = "[ERROR] U와 D 중에서 하나를 입력해주세요.";

    public static void bridgeSizeException(String size) {
        if (!Pattern.matches(NUMERICAL_REGULAREXPRESSION, size)) {
            throw new IllegalArgumentException(NOTNUMBER_ERRORMESSAGE);
        }
        if (Integer.valueOf(size) < MINIMUM_BRIDGESIZE || Integer.valueOf(size) > MAXIMUM_BRIDGESIZE) {
            throw new IllegalArgumentException(OUTOFSIZERANGE_ERRORMESSAGE);
        }
    }

    public static void movingException(String moving) {
        if (!moving.equals(BridgeDirection.UP.getDirection()) && !moving.equals(BridgeDirection.DOWN.getDirection())) {
            throw new IllegalArgumentException(INVALIDMOVING_ERRORMESSAGE);
        }
    }
}
