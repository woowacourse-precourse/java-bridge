package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Collections;
import java.util.List;

public class BridgeGameController {

    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;


    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.printStartMessage();
        final int bridgeSize = decideBridgeLength();
        bridgeGame = new BridgeGame(generateBridge(bridgeSize));
        BridgeGameProcessor bridgeGameProcessor = new BridgeGameProcessor(bridgeGame);
        bridgeGameProcessor.crossBridge();
        displayResult();
    }

    public int decideBridgeLength() {
        outputView.printInputBridgeLengthMessage();
        final int bridgeSize = inputView.readBridgeSize();

        return bridgeSize;
    }

    public List<String> generateBridge(int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        final List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return bridge;
    }


    public void displayResult() {
        int retrialNumber = bridgeGame.getRetrialNumber();
        boolean gameSuccess = bridgeGame.getGameSuccess();
        List<String> userBridge = Collections.unmodifiableList(bridgeGame.getUserBridge());

        outputView.printResult(retrialNumber, gameSuccess, userBridge);
    }
}
