package bridge;

import java.util.regex.Pattern;

public class Validate {
    private final static String NUMERIC_PATTERN = "^[0-9]*$";
    private final static String UP_OR_DOWN_PATTERN = "^[UD]*$";
    private final static String RESTART_OR_QUIT_PATTERN = "^[RQ]*$";
    private final static int MAX_BRIDGE_SIZE = 20;
    private final static int MIN_BRIDGE_SIZE = 3;
    private final static String RANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final static String MOVING_ERROR = "[ERROR] 이동할 칸은 U또는 D 중 하나의 문자여야 합니다.";
    private final static String COMMAND_ERROR = "[ERROR] 게임 재시작/종료 여부는 R또는 Q 중 하나의 문자여야합니다.";

    private boolean isNumeric(String input) {
        return Pattern.matches(NUMERIC_PATTERN, input);
    }

    private boolean isBridgeSizeRange(String input) {
        if (isNumeric(input)){
            return (MIN_BRIDGE_SIZE <= Integer.parseInt(input)
                    && Integer.parseInt(input) <= MAX_BRIDGE_SIZE);
        }
        return false;
    }

    public void isBridgeSize(String input){
        if (!isBridgeSizeRange(input)) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private boolean isUpOrDown(String input) {
        return Pattern.matches(UP_OR_DOWN_PATTERN, input);
    }

    public void isMoving(String input) {
        if (!isUpOrDown(input)){
            throw new IllegalArgumentException(MOVING_ERROR);
        }
    }

    private boolean isRestartOrQuit(String input) {
        return Pattern.matches(RESTART_OR_QUIT_PATTERN, input);
    }

    public void isGameCommand(String input) {
        if (!isRestartOrQuit(input)){
            throw new IllegalArgumentException(COMMAND_ERROR);
        }
    }
}
