package bridge.controller;

import bridge.model.BridgeGame;
import bridge.util.Validator;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import static bridge.util.ErrorCode.*;

public class BridgeGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();

    public void run() {
        outputView.printStartMessage();
        int bridgeSize = getBridgeSizeInput();

        BridgeGame bridgeGame = new BridgeGame();
    }

    public int getBridgeSizeInput() {
        int bridgeSize = 0;
        try {
            bridgeSize = inputView.readBridgeSize();
            checkBridgeSize(bridgeSize);
        } catch (NumberFormatException e) {
            outputView.printErrorMessage(INVALID_BRIDGE_SIZE_TYPE);
            getBridgeSizeInput();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(INVALID_BRIDGE_SIZE_RANGE);
            getBridgeSizeInput();
        }
        return bridgeSize;
    }

    public void checkBridgeSize(int size) {
        if (!validator.isValidRange(size)) {
            throw new IllegalArgumentException();
        }
    }
}