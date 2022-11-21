package bridge.view;

import bridge.message.ErrorMessage;
import bridge.message.Message;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static String bridgeSize;
    private static String moving;
    private static String gameCommand;

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            bridgeSize = Console.readLine();
            validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            readBridgeSize();
        }

        return Integer.parseInt(bridgeSize);
    }

    public static void validateBridgeSize(String bridgeSize) {
        if (isNotNumber(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_IS_NOT_DIGIT.getErrorMessage());
        }
        if (isLengthOutOfRange(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_OUT_OF_RANGE.getErrorMessage());
        }
    }

    private static boolean isNotNumber(String bridgeSize) {
        return !bridgeSize.matches("^-?[0-9]+$");
    }

    private static boolean isLengthOutOfRange(int bridgeSize) {
        return bridgeSize < 3 || bridgeSize > 20;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        try {
            moving = Console.readLine();
            validateMoving(moving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            readMoving();
        }

        return moving;
    }

    public static void validateMoving(String moving) {
        if (isNotUD(moving)) {
            throw new IllegalArgumentException(ErrorMessage.MOVING_IS_NOT_U_D.getErrorMessage());
        }
    }

    private static boolean isNotUD(String moving) {
        return !moving.equals(Message.UP.getMessage()) && !moving.equals(Message.DOWN.getMessage());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        try {
            gameCommand = Console.readLine();
            validateGameCommand(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            readGameCommand();
        }

        return gameCommand;
    }

    private static void validateGameCommand(String gameCommand) {
        if (isNotRQ(gameCommand)) {
            throw new IllegalArgumentException(ErrorMessage.GAME_COMMAND_IS_NOT_Q_R.getErrorMessage());
        }
    }

    private static boolean isNotRQ(String gameCommand) {
        return !gameCommand.equals(Message.RETRY.getMessage()) && !gameCommand.equals(Message.QUIT.getMessage());
    }
}
