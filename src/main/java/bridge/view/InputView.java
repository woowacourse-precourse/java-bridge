package bridge.view;

import bridge.util.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        Validator.validateNumericInputType(bridgeSize);
        int size = Integer.parseInt(bridgeSize);
        Validator.validateBridgeSize(size);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        Validator.validateMovingInput(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        Validator.validateGameCommandInput(input);
        return input;
    }
}
