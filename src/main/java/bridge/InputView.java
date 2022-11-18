package bridge;

import bridge.validator.BridgeSizeValidator;
import bridge.validator.MovingValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String input = Console.readLine();
        return BridgeSizeValidator.validate(input);
    }

    public String readMoving() {
        String input = Console.readLine();
        MovingValidator.validate(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
