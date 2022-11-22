package bridge.view;

import bridge.constant.BridgeChoice;
import bridge.constant.ExceptionMessage;
import bridge.constant.GameCommand;
import bridge.constant.InputMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final int MINIMUM_BRIDGE_LENGTH = 3;
    private final int MAXIMUM_BRIDGE_LENGTH = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(InputMessage.GAME_START.getInputMessage());
        System.out.println(InputMessage.INPUT_BRIDGE_LENGTH.getInputMessage());
        String bridgeSize = Console.readLine();
        isNumber(bridgeSize);
        checkScope(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(InputMessage.INPUT_MOVING_COMMAND.getInputMessage());
        String upDown = Console.readLine();
        isMovingCommand(upDown);
        return upDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(InputMessage.INPUT_RESTART_COMMAND.getInputMessage());
        String command = Console.readLine();
        checkCommand(command);
        return command;
    }

    public void isNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NUMBER.getErrorMessage());
        }
    }

    public void checkScope(String number) {
        int bridgeLength = Integer.parseInt(number);
        if (bridgeLength < MINIMUM_BRIDGE_LENGTH || bridgeLength > MAXIMUM_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.SCOPE.getErrorMessage());
        }
    }

    public void isMovingCommand(String alphabet) {
        if (!(alphabet.equals(BridgeChoice.UP.getDirection()) || alphabet.equals(BridgeChoice.DOWN.getDirection()))) {
            throw new IllegalArgumentException(ExceptionMessage.MOVING_COMMAND.getErrorMessage());
        }
    }

    public void checkCommand(String command) {
        if (!(command.equals(GameCommand.RESTART.getCommand()) || command.equals(GameCommand.QUIT.getCommand()))) {
            throw new IllegalArgumentException(ExceptionMessage.RESTART_COMMAND.getErrorMessage());
        }
    }
}
