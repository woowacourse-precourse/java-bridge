package bridge.service;

import static bridge.exception.Error.*;
import static bridge.view.OutputView.*;

import bridge.repository.BridgeRepository;
import bridge.view.InputView;

public class BridgeGameService {

    private BridgeRepository bridgeRepository;

    public void execute() {
        InputView inputView = new InputView();

        printBridgeGameStartMessage();

        try {
            initializeBridgeRepositoryByBridgeSize(inputView.readBridgeSize());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_INT.getMessage());
        }

    }

    private void initializeBridgeRepositoryByBridgeSize(int size) {
        bridgeRepository = new BridgeRepository(size);
    }

}
