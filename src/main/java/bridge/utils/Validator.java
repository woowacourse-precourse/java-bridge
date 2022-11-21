package bridge.utils;

import bridge.domain.Bridge;

public class Validator {
    private static final String RANGE_ERROR = "[ERROR] 다리 길이는 "
            + Bridge.MIN + "부터 " + Bridge.MAX + " 사이의 숫자여야 합니다.";
    private static final String DIRECTION_ERROR = "[ERROR] 방향이 올바르지 않습니다.";
    private static final String COMMAND_ERROR = "[ERROR] 명령어가 올바르지 않습니다.";

    public static void checkSizeRange(int size) {
        if (isUnderMin(size) || isOverMax(size)) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    public static void checkMovingDirection(String direction) {
        if (!isUp(direction) && !isDown(direction)) {
            throw new IllegalArgumentException(DIRECTION_ERROR);
        }
    }

    public static void checkCommand(String command) {
        if (!isEnd(command) && !isRestart(command)) {
            throw new IllegalArgumentException(COMMAND_ERROR);
        }
    }

    private static boolean isUnderMin(int size) {
        return size < Bridge.MIN;
    }

    private static boolean isOverMax(int size) {
        return size > Bridge.MAX;
    }

    private static boolean isUp(String direction) {
        return direction.equals(BridgeDirection.UP.getDirection());
    }

    private static boolean isDown(String direction) {
        return direction.equals(BridgeDirection.DOWN.getDirection());
    }

    private static boolean isEnd(String command) {
        return command.equals(GameCommand.END.getCommand());
    }

    private static boolean isRestart(String command) {
        return command.equals(GameCommand.RESTART.getCommand());
    }
}
