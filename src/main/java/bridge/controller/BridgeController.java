package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() throws IllegalArgumentException {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        while (true) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getResult());
            if (bridgeGame.isEnd()) {
                outputView.printResult(bridgeGame.getResult(), bridgeGame.isGameFail(), BridgeGame.tryCount);
                return;
            }
            if (bridgeGame.isGameFail()) {
                if (inputView.readGameCommand().equals("Q")) {
                    outputView.printResult(bridgeGame.getResult(), true, BridgeGame.tryCount);
                    return;
                }
                bridgeGame.retry();
            }
        }

    }
}
