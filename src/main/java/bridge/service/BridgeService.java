package bridge.service;

import bridge.BridgeMaker;
import bridge.type.ErrorMessage;
import bridge.validation.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeService {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    private final Validator validator;

    public BridgeService(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.validator = validator;
    }

    public List<String> makeBridge() {
        outputView.printGreetingMessage();
        int bridgeSize = getBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }

    private int getBridgeSize() {
        while (true) {
            String bridgeSizeInput = inputView.readBridgeSize();
            try {
                checkBridgeSizeInput(bridgeSizeInput);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                continue;
            }
            return Integer.parseInt(bridgeSizeInput);
        }
    }

    private void checkBridgeSizeInput(String bridgeSizeInput) {
        if (!validator.isNumeric(bridgeSizeInput)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_NUMERIC.getMessage());
        }
        if (!validator.isCorrectBoundary(bridgeSizeInput)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_BOUNDARY.getMessage());
        }


    }
}
