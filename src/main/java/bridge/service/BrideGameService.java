package bridge.service;

import static bridge.exception.Error.*;
import static bridge.exception.Validator.*;
import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

import bridge.BridgeRandomNumberGenerator;
import bridge.maker.BridgeMaker;
import java.util.List;

public class BrideGameService {

    private int bridgeSize;
    private List<String> bridges;

    public void execute() {
        printBridgeGameStartMessage();

        try {
            bridgeSize = readBridgeSize();
            checkBridgeLength(bridgeSize);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_INT.getMessage());
        }

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridges = bridgeMaker.makeBridge(bridgeSize);

    }


}
