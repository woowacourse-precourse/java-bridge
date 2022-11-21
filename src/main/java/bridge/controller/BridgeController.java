package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private List<String> answerBridge;

    public BridgeController(int size) {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        answerBridge = bridgeMaker.makeBridge(size);
        for (String s : answerBridge) {
            System.out.print(s + " ");
        }
        bridgeGame = new BridgeGame(answerBridge, 1);
    }

    public void start() {
        while (true) {
            boolean isPossible = isPossibleMove();
            if (isPossible && bridgeGame.isSuccess()) {break;}
            if (isPossible){continue;}
            if (!isRetry()) {break;}
        }
        OutputView.printResult(bridgeGame.getPlayerBridge(), answerBridge, bridgeGame.getCount());
    }

    private boolean isPossibleMove() {
        String upDown = InputView.readMoving();
        String result = bridgeGame.move(upDown);
        System.out.println(result);
        if (result.contains("X")) {
            return false;
        }
        return true;
    }

    private boolean isRetry() {
        String retryInput = InputView.readGameCommand();
        return bridgeGame.retry(retryInput);
    }

}
