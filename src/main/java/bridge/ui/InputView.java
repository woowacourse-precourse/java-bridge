package bridge.ui;

import bridge.domain.GameCommand;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.DirectionSelectionValidator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.ui.ViewConstant.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String bridgeSize = getAnswer(INPUT_BRIDGE_SIZE_MESSAGE);
            System.out.print(LINE_FEED);
            BridgeSizeValidator.validate(bridgeSize);
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String direction = getAnswer(INPUT_DIRECTION_MESSAGE);
            DirectionSelectionValidator.validate(direction);
            return direction;
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
            String restartWhether = getAnswer(INPUT_RESTART_WHETHER_MESSAGE);
            return GameCommand.getByCommandString(restartWhether);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readGameCommand();
        }
    }

    private String getAnswer(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
