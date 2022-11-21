package bridge.view;

import bridge.utils.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String REGEX_NUMBER = "^[0-9]*$";
    private static final String REGEX_MOVING = "^D|U$";
    private static final String REGEX_GAME_COMMAND = "^R|Q$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String bridgeSize = Console.readLine();
            validateBridgeSizeInput(bridgeSize);
            System.out.println();
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String moving = Console.readLine();
            validateMoving(moving);
            return moving;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String gameCommand = Console.readLine();
            validateGameCommand(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private void validateBridgeSizeInput(String bridgeSize) throws IllegalArgumentException {
        if (!bridgeSize.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE);
        }
        int bridgeSizeNumber = Integer.parseInt(bridgeSize);
        if (bridgeSizeNumber < 3 || bridgeSizeNumber > 20) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE);
        }
    }

    private void validateMoving(String moving) throws IllegalArgumentException {
        if (!moving.matches(REGEX_MOVING)) {
            throw new IllegalArgumentException(ErrorMessage.MOVING);
        }
    }

    private void validateGameCommand(String gameCommand) throws IllegalArgumentException{
        if (!gameCommand.matches(REGEX_GAME_COMMAND)) {
            throw new IllegalArgumentException(ErrorMessage.GAME_COMMAND);
        }
    }
}
