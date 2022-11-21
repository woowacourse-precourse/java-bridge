package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String UP_BRIDGE = "U";
    private static final String DOWN_BRIDGE = "D";
    private static final String RESTART_GAME = "R";
    private static final String END_GAME = "Q";

    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String ONLY_CONTAINS_NUMBER_REGEX = "^[0-9]*$";
    private static final String RANGE_ERROR = "[ERROR] 3에서 20까지의 숫자를 입력해 주시기 바랍니다.";
    private static final String NUMBER_ERROR = "[ERROR] 올바른 숫자가 아닙니다.";
    private static final String MOVING_COMMAND_ERROR = "[ERROR] 입력은 대문자 'U' 또는 'D'를 입력해 주시기 바랍니다.\n";
    private static final String RETRY_COMMAND_ERROR = "[ERROR] 입력은 대문자 'R' 또는 'Q'를 입력해 주시기 바랍니다.\n";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        String readLine = Console.readLine();
        try {
            validateRange(readLine);
            validateType(readLine);
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateRange(String readLine) {
        int readLength = Integer.parseInt(readLine);
        if (readLength > MAX_BRIDGE_SIZE || readLength < MIN_BRIDGE_SIZE) {
            System.out.println(RANGE_ERROR);
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private void validateType(String readLine) {
        if (!readLine.matches(ONLY_CONTAINS_NUMBER_REGEX)) {
            System.out.println(NUMBER_ERROR);
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println(INPUT_MOVING);
            return isMovingCommand(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private String isMovingCommand(String readLine) {
        if (!(UP_BRIDGE.equals(readLine) || DOWN_BRIDGE.equals(readLine))) {
            throw new IllegalArgumentException(MOVING_COMMAND_ERROR);
        }
        return readLine;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println(INPUT_GAME_COMMAND);
            return isGameCommand(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private String isGameCommand(String readLine) {
        if (!(RESTART_GAME.equals(readLine) || END_GAME.equals(readLine))) {
            throw new IllegalArgumentException(RETRY_COMMAND_ERROR);
        }
        return readLine;
    }
}
