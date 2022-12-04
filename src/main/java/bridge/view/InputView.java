package bridge.view;

import bridge.model.bridge.Bridge;
import bridge.model.bridge.BridgeDirection;
import bridge.model.command.GameCommand;
import bridge.util.validator.BridgeSizeValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private enum ConsoleMessage {
        INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
        INPUT_MOVING_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(ConsoleMessage.INPUT_BRIDGE_SIZE.message);
            String input = Console.readLine();
            return new BridgeSizeValidator().validate(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeDirection readMoving() {
        try {
            System.out.println(ConsoleMessage.INPUT_MOVING_DIRECTION.message);
            String movingDirection = Console.readLine();
            return BridgeDirection.from(movingDirection);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        try {
            System.out.println(ConsoleMessage.INPUT_GAME_COMMAND.message);
            String gameCommand = Console.readLine();
            return GameCommand.from(gameCommand);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readGameCommand();
        }
    }
}
