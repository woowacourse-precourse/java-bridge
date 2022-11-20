package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String CHECK_NUMBER_REGEX = "^[0-9]*$";
    private static final String MOVE_UP = "U";
    private static final String MOVE_DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String TYPE_ERROR = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INPUT_COMMAND_ERROR = "[ERROR] U 또는 D만 입력해주세요. 위는 U, 아래는 D를 입력해주세요.";
    private static final String GAME_COMMAND_ERROR = "[ERROR] R 또는 Q만 입력 가능합니다. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        try {
            isDigit(bridgeSize);
            validateBridgeSize(Integer.parseInt(bridgeSize));
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readBridgeSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(INPUT_MOVE);
        String command = Console.readLine();
        try {
            validateMoveCommand(command);
            return command;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(INPUT_GAME_COMMAND);
        String gameCommand = Console.readLine();
        try{
            validateGameCommand(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readGameCommand();
    }

    private static void isDigit(String input) {
        if(!input.matches(CHECK_NUMBER_REGEX)) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }

    private static void validateBridgeSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }

    private static void validateMoveCommand(String input) {
        if (input.matches(MOVE_UP) || input.matches(MOVE_DOWN)) {
            return;
        }
        throw new IllegalArgumentException(INPUT_COMMAND_ERROR);
    }

    private static void validateGameCommand(String input) {
        if (input.matches(RESTART) || input.matches(QUIT)) {
            return;
        }
        throw new IllegalArgumentException(GAME_COMMAND_ERROR);
    }
}
