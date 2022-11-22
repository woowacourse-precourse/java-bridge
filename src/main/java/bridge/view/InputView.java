package bridge.view;

import bridge.exception.BridgeException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    BridgeException bridgeException = new BridgeException();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String BridgeSize = Console.readLine();
            bridgeException.checkBridgeLengthExceptions(BridgeSize);
            return Integer.parseInt(BridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }
    }

    현
}
