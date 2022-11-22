package bridge.controller;

import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private List<String> bridge;

    public void startBridgeGame() {
        init();
        boolean b = true;

        bridgeGame = new BridgeGame(bridge);
        do {
            bridgeGame.move(InputView.getMoving());
            OutputView.printMap(bridgeGame);
            if(bridgeGame.getGameSuccess()!="성공") {
                String gameCommand = InputView.getGameCommand();
                if (gameCommand.equals("Q")) {
                    b = false;
                }
                if (gameCommand.equals("R")) {
                    bridgeGame.retry();
                    bridgeGame.totalGamePlus();
                }
            }
        } while (b && bridgeGame.getUpPresentBridge().size() != bridge.size());
        OutputView.printResult(bridgeGame);
    }

    public void init() {
        OutputView.printGameStart();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(InputView.getBridgeSize());
    }
}
