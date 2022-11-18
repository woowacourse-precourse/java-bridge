package bridge.util;

public class ParserUtil {

    static final int BRIDGE_SIZE_MIN_NUM = 3;
    static final int BRIDGE_SIZE_MAX_NUM = 20;

    public static void parseBridgeSize(String input) {
        if (input.isBlank() || !ValidationUtil.isDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
        int bridgeSize = Integer.parseInt(input);
        if (!ValidationUtil.isRange(bridgeSize, BRIDGE_SIZE_MIN_NUM
                , BRIDGE_SIZE_MAX_NUM)) {
            throw new IllegalArgumentException("[ERROR] 3부터 20까지 숫자가 아닙니다.");
        }
    }

}





