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
        String bridgeSizeInput = inputView.readBridgeSize();
        checkBridgeSizeInput(bridgeSizeInput);
        return null;
    }

    private void checkBridgeSizeInput(String bridgeSizeInput) {
        if (!validator.isNumeric(bridgeSizeInput)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_NUMERIC.getMessage());
        }
        if (validator.isCorrectBoundary(bridgeSizeInput)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_BOUNDARY.getMessage());
        }


    }
}
