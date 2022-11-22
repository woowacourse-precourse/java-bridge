package bridge.controller;

import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.StartBridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private static BridgeGame bridgeGame;
    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final InputView inputView = new InputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private static final OutputView outputView = new OutputView();
    private static final StartBridgeGame startBridgeGame = new StartBridgeGame();

    public void play() {
        outputView.printGameStart();
        bridgeGame = startBridgeGame.start(bridgeMaker, inputView);
        boolean game = true;

        while(game) {
            if(bridgeGame.checkGameIsDone()) break;
            game = playerMove();
        }
        outputView.printResult(bridgeGame);
    }

    public boolean playerMove() {
        String move = inputView.readMoving();
        boolean game = bridgeGame.move(move);
        outputView.printMap(bridgeGame);

        if (!game) {
            game = bridgeGame.retry(inputView.readGameCommand());
        }

        return game;
    }
}
