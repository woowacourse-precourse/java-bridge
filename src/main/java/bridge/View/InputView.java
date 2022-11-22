package bridge.View;

import bridge.Domain.ErrorMessage;
import bridge.Domain.GameMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            System.out.println(GameMessage.BRIDGE_SIZE_PHRASE.getGameMessage());
            String userInputLengthOfBridge = Console.readLine();
            validateBridgeLengthNotNumber(userInputLengthOfBridge);
            validateBridgeLength(userInputLengthOfBridge);
            return Integer.parseInt(userInputLengthOfBridge);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(GameMessage.MOVING_BRIDGE_PHRASE.getGameMessage());
        String input = Console.readLine();
        validateIsUOrD(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(GameMessage.QUIT_OR_RESTART_PHRASE.getGameMessage());
        String input = Console.readLine();
        validateIsROrQ(input);
        return input;
    }

    public static void validateBridgeLength(String input) {
        if (Integer.parseInt(input) < 2 || Integer.parseInt(input) > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getErrorMessage());
        }
    }

    private static void validateBridgeLengthNotNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CANT_CONVERT_INTEGER.getErrorMessage());
        }
    }

    private static void validateIsUOrD(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getErrorMessage());
        }
    }

    private static void validateIsROrQ(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getErrorMessage());
        }
    }
}
