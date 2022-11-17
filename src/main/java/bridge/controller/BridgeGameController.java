package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.util.Converter;
import bridge.util.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.util.ErrorCode.*;

public class BridgeGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();
    private final Converter converter = new Converter();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void run() {
        outputView.printStartMessage();
        getBridgeSizeInputAndStartGame();
    }

    public void startGame(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String moving = inputView.readMoving();
    }

    public void getBridgeSizeInputAndStartGame() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            validateBridgeSize(bridgeSize);
            startGame(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(INVALID_BRIDGE_SIZE);
            getBridgeSizeInputAndStartGame();
        }
    }

    public void validateBridgeSize(int size) {
        if (!validator.isValidRange(size)) {
            throw new IllegalArgumentException();
        }
    }
}
