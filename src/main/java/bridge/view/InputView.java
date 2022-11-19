package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String NUMERIC_REGEX = "^[1-9]\\d*$";
    private static final String UP_BRIDGE = "U";
    private static final String DOWN_BRIDGE = "D";
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";
    private static final int START_RANGE = 3;
    private static final int END_RANGE = 20;
    private static final String ASK_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String ASK_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ASK_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String NUMERIC_ERROR = "[ERROR] 올바른 숫자가 아닙니다.\n";
    private static final String RANGE_ERROR = "[ERROR] 3에서 20까지의 숫자를 입력해 주시기 바랍니다.\n";
    private static final String MOVING_COMMAND_ERROR = "[ERROR] U 또는 D를 입력해 주시기 바랍니다.\n";
    private static final String GAME_COMMAND_ERROR = "[ERROR] R 또는 Q를 입력해 주시기 바랍니다.\n";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(ASK_BRIDGE_SIZE);
            return validCheckBridgeSize(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private int validCheckBridgeSize(String readline) {
        isNumeric(readline);
        isRange(Integer.parseInt(readline));
        return Integer.parseInt(readline);
    }

    private void isRange(int size) {
        if (size < START_RANGE || size > END_RANGE) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private void isNumeric(String readline) {
        if (!Pattern.matches(NUMERIC_REGEX, readline)) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println(ASK_MOVING);
            return isMovingCommand(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private String isMovingCommand(String readline) {
        if (!(UP_BRIDGE.equals(readline) || DOWN_BRIDGE.equals(readline))) {
            throw new IllegalArgumentException(MOVING_COMMAND_ERROR);
        }
        return readline;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println(ASK_RETRY);
            return isGameCommand(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private String isGameCommand(String readline) {
        if (!(RETRY_COMMAND.equals(readline) || QUIT_COMMAND.equals(readline))) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR);
        }
        return readline;
    }

}
