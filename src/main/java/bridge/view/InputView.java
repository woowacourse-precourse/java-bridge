package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String MOVING_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String RETRY_GAME_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static void printBridgeSizeMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
    }

    private static int readNumber() throws IllegalArgumentException {
        String inputNumber = Console.readLine();
        System.out.println();
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorCode.INVALID_BRIDGE_LENGTH.toString());
        }
    }

    private static int readValidRangeNumber() throws IllegalArgumentException {
        int number = readNumber();

        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(InputErrorCode.INVALID_BRIDGE_LENGTH.toString());
        }
        return number;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        while (true) {
            try {
                printBridgeSizeMessage();
                return readValidRangeNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readMovingCommand() throws IllegalArgumentException {
        String inputCommand = Console.readLine();

        if (!(inputCommand.equals("U") || inputCommand.equals("D")))
            throw new IllegalArgumentException(InputErrorCode.INVALID_MOVING_COMMAND.toString());
        return inputCommand;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        while (true) {
            try {
                System.out.println(MOVING_INPUT_MESSAGE);
                return readMovingCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readRetryCommand() throws IllegalArgumentException {
        String inputCommand = Console.readLine();

        if (!(inputCommand.equals("R") || inputCommand.equals("Q")))
            throw new IllegalArgumentException(InputErrorCode.INVALID_RETRY_GAME_COMMAND.toString());
        return inputCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        while (true) {
            try {
                System.out.println(RETRY_GAME_INPUT_MESSAGE);
                return readRetryCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
