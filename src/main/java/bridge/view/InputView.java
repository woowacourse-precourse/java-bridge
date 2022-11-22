package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import bridge.model.Validation;

public class InputView {

    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        while (!Validation.bridgeSizeVerification(bridgeSize)){
            bridgeSize = Console.readLine();
        }
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String moveDirection = Console.readLine();
        while (!Validation.moveDirectionVerification(moveDirection)){
            moveDirection = Console.readLine();
        }
        return moveDirection;
    }

    public String readGameCommand() {
        String retry = Console.readLine();
        while (!Validation.retryValueVerification(retry)){
            retry = Console.readLine();
        }
        return retry;
    }
}
