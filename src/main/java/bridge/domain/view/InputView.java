package bridge.domain.view;

import bridge.exception.InputExceptionHandler;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();
        InputExceptionHandler.handleBridgeSizeInputException(bridgeSizeInput);

        int bridgeSize = Integer.parseInt(bridgeSizeInput);

        return bridgeSize;
    }

    public String readMoving() {
        String movingInput = Console.readLine();
        InputExceptionHandler.handleMoveAndRetryException(movingInput);

        return movingInput;
    }

    public String readGameCommand() {
        String retryInput = Console.readLine();
        InputExceptionHandler.handleMoveAndRetryException(retryInput);

        return retryInput;
    }
}
