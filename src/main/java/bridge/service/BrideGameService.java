package bridge.service;

import static bridge.exception.Error.*;
import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

import bridge.repository.BridgeRepository;

public class BrideGameService {

    private BridgeRepository bridgeRepository;

    public void execute() {
        printBridgeGameStartMessage();

        try {
            initializeBridgeRepositoryByBridgeSize(readBridgeSize());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_INT.getMessage());
        }

    }

    private void initializeBridgeRepositoryByBridgeSize(int size) {
        bridgeRepository = new BridgeRepository(readBridgeSize());
    }

}
