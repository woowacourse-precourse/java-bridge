package bridge;

import bridge.validator.BridgeSizeValidator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.ui.ViewConstant.INPUT_BRIDGE_SIZE;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(INPUT_BRIDGE_SIZE);
            String bridgeSize = Console.readLine();
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
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
