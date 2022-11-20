package View;

import Util.Exception;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    Exception exception = new Exception();

    public int readBridgeSize() {
        String bridgeSize;
        bridgeSize = Console.readLine();
        exception.validateIfInputIsNumber(bridgeSize);
        exception.validateInputNumberRange(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String moving;
        moving = Console.readLine();
        exception.validateMovingInput(moving);
        return moving;
    }

    public String readGameCommand() {
        String gameCommand;
        gameCommand = Console.readLine();
        exception.validateRetryInput(gameCommand);
        return gameCommand;
    }
}
