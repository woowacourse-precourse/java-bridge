package bridge.util;

public class ParserUtil {

    private static final int BRIDGE_SIZE_MIN_NUM = 3;
    private static final int BRIDGE_SIZE_MAX_NUM = 20;
    private static final String GAME_RETRY_COMMEND = "R";
    private static final String GAME_QUIT_COMMEND = "Q";

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

    public static void parseMovement(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 존재하지 않습니다.");
        }
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U 또는 D가 아닙니다.");
        }
    }

    public static void parseGameCommand(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 존재하지 않습니다.");
        }
        if (!input.equals(GAME_RETRY_COMMEND) && !input.equals(GAME_QUIT_COMMEND)) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q가 아닙니다.");
        }
    }



}





