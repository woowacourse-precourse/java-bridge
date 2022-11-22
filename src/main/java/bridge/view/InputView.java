package bridge.view;

import bridge.exception.BridgeException;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final BridgeException bridgeException = new BridgeException();

    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        bridgeException.isValidBridge(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMovement() {
        String move = Console.readLine();
        bridgeException.isMovement(move);
        return move;
    }


    public String readDecision() {
        String decision = Console.readLine();
        bridgeException.isDecision(decision);
        return decision;
    }
}
