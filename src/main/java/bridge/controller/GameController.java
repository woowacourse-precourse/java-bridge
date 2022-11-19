package bridge.controller;

import bridge.constants.InputMessage;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.service.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputMessage inputMessage = new InputMessage();
    private final Validator validator = new Validator();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void startGame() {
        inputView.printMessage(inputMessage.START_GAME);
        int bridgeSize = inputView.readBridgeSize();
        setBridgeSize(bridgeSize);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        String direction = inputView.readMoving();
    }
    public void setBridgeSize(int bridgeSize) {
        try {
            validator.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            bridgeSize = inputView.readBridgeSize();
            setBridgeSize(bridgeSize);
        }
    }
}
