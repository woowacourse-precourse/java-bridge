package bridge.view;

import static bridge.utils.command.MoveCommand.DOWN;
import static bridge.utils.command.MoveCommand.UP;

import bridge.utils.message.FixedMessage;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.MovingValidator;
import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            Validator bridgeSizeValidator = new BridgeSizeValidator();
            System.out.println(FixedMessage.INPUT_BRIDGE_SIZE.getMessage());
            String bridgeSize = Console.readLine();
            bridgeSizeValidator.validate(bridgeSize);
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException exception) {
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            Validator movingValidator = new MovingValidator();
            System.out.println(
                    String.format(FixedMessage.INPUT_MOVING.getMessage(), UP.getCommand(), DOWN.getCommand()));
            String moving = Console.readLine();
            movingValidator.validate(moving);
            return moving;
        } catch (IllegalArgumentException exception) {
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
