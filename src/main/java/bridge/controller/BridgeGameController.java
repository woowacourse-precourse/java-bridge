package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.validator.BridgeSizeValidator;
import bridge.view.InputView;

import java.util.List;

public class BridgeGameController {
    InputView inputView = new InputView();
    BridgeGame bridgeGame;

    public void runGame() {
        bridgeGame = new BridgeGame(createBridgeByUserInputSize());

    }

    public List<String> createBridgeByUserInputSize() {
        BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();
        int bridgeSize = bridgeSizeValidator.getValidBridgeSize(inputView.readBridgeSize());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
