package bridge.view;

import bridge.domain.Constants;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(Constants.INPUT_BRIDGE_LENGTH_GUIDE_MESSAGE);
        return convertBridgeSize(Console.readLine());
    }

    private static int convertBridgeSize(String input) {
        try {
            validateOnlyNumbers(input);
            return validateSizeOfNumber(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private static void validateOnlyNumbers(String input) {
        if (!input.matches(Constants.ONLY_NUMBERS_REGEX)) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_BRIDGE_LENGTH_MESSAGE);
        }
    }

    private static int validateSizeOfNumber(String input) {
        int number = Integer.parseInt(input);

        if (number < Constants.MIN_BRIDGE_SIZE || number > Constants.MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_BRIDGE_LENGTH_MESSAGE);
        }

        return number;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        try {
            System.out.println(Constants.INPUT_MOVE_COMMAND_GUIDE_MESSAGE);
            return validateMoveCommand(Console.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private static String validateMoveCommand(String input) {
        if (!input.equals(Constants.UP_COMMAND) && !input.equals(Constants.DOWN_COMMAND)) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_MOVE_COMMAND_MESSAGE);
        }

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        try {
            System.out.println(Constants.INPUT_GAME_COMMAND_GUIDE_MESSAGE);
            return validateGameCommand(Console.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private static String validateGameCommand(String input) {
        if (!input.equals(Constants.RETRY_COMMAND) && !input.equals(Constants.QUITE_COMMAND)) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_GAME_COMMAND_MESSAGE);
        }

        return input;
    }
}
