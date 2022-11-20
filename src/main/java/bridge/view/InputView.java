package bridge.view;

import bridge.util.validator.BridgeSizeValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        final BridgeSizeValidator validator = new BridgeSizeValidator();
        String bridgeSize;
        boolean isValid;

        do {
            bridgeSize = Console.readLine();
            isValid = validator.validate(bridgeSize);
        } while (!isValid);

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String direction = Console.readLine();

        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();

        return command;
    }
}
