package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import bridge.model.Validation;

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
        while (!Validation.moveDirectionTest(moveDirection)){
            moveDirection = Console.readLine();
        }
        return moveDirection;
    }

    public String readGameCommand() {
        String retry = Console.readLine();
        while (!Validation.retryTest(retry)){
            retry = Console.readLine();
        }
        return retry;
    }
}
