package bridge.service;

import static bridge.exception.Error.*;
import static bridge.exception.Validator.*;
import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class BrideGameService {

    public void execute() {
        printBridgeGameStartMessage();

        try {
            int bridgeLength = readBridgeSize();
            checkBridgeLength(bridgeLength);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_INT.getMessage());
        }
    }

}
