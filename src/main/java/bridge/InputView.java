package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;

    private static final String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String PARSE_STR_TO_INT_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    private static final String VALIDATE_BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String VALIDATE_MOVING_ERROR_MESSAGE = "[ERROR] U 또는 D를 입력해야 합니다.";
    private static final String VALIDATE_GAME_COMMAND_ERROR_MESSAGE = "[ERROR] R 또는 Q를 입력해야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE_MESSAGE);
        try {
            return validateBridgeSize(parseStrToInt(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(READ_MOVING_MESSAGE);
        try {
            return validateMoving(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(READ_GAME_COMMAND_MESSAGE);
        try {
            return validateGameCommand(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    /**
     * String을 Integer로 파싱한다.
     * 숫자가 아닌 문자일 경우 IllegalArgumentException을 발생 시킨다.
     */
    private int parseStrToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PARSE_STR_TO_INT_ERROR_MESSAGE);
        }
    }

    /**
     * 매개변수 size가 3 이상 20 이하가 아니면 IllegalArgumentException을 발생 시킨다.
     */
    private int validateBridgeSize(int size) {
        if (size < BRIDGE_SIZE_MIN || size > BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException(VALIDATE_BRIDGE_SIZE_ERROR_MESSAGE);
        }
        return size;
    }

    /**
     * 매개변수 moving이 U나 D가 아니면 IllegalArgumentException을 발생 시킨다.
     */
    private String validateMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException(VALIDATE_MOVING_ERROR_MESSAGE);
        }
        return moving;
    }

    /**
     * 매개변수 gameCommand가 R이나 Q가 아니면 IllegalArgumentException을 발생 시킨다.
     */
    private String validateGameCommand(String gameCommand) {
        if (!(gameCommand.equals("R") || gameCommand.equals("Q"))) {
            throw new IllegalArgumentException(VALIDATE_GAME_COMMAND_ERROR_MESSAGE);
        }
        return gameCommand;
    }
}
