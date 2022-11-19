package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import bridge.model.Validation;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        while (!Validation.bridgeSizeValidationTest(bridgeSize)){
            bridgeSize = Console.readLine();
        }
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String moveDirection = Console.readLine();
        while (!Validation.bridgeSizeValidationTest(moveDirection)){
            moveDirection = Console.readLine();
        }
        return moveDirection;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
