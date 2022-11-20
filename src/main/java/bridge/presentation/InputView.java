package bridge.presentation;

import bridge.ExceptionHandler;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        String input = Console.readLine();
        ExceptionHandler.checkNullInput(input);
        ExceptionHandler.checkIsNumber(input);

        int bridgeSize = Integer.parseInt(input);
        ExceptionHandler.checkOutOfRange(bridgeSize);

        return bridgeSize;
    }
}