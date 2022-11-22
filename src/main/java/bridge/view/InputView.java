package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.validator.BridgeSizeValidator.validateBridgeSize;
import static bridge.validator.MovingValidator.validateMoving;
import static bridge.validator.GameCommandValidator.validateGameCommand;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();
        validateBridgeSize(bridgeSizeInput);
        return Integer.parseInt(bridgeSizeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingInput = Console.readLine();
        validateMoving(movingInput);
        return movingInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommandInput = Console.readLine();
        validateGameCommand(gameCommandInput);
        return gameCommandInput;
    }
}
