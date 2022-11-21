package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.User;
import bridge.domain.utils.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private GameState gameState;

    public BridgeController() {
        gameState = GameState.START;
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.printStartGame();
        final BridgeGame bridgeGame = generateBridgeGame(new BridgeRandomNumberGenerator());
        final User user = new User();
        final Bridge bridge = bridgeGame.makeBridgeGame(inputView.readBridgeSize());
        playGame(user, bridge, bridgeGame);
    }

    public BridgeGame generateBridgeGame(BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new BridgeGame(bridgeMaker);
    }

    public void playGame(User user, Bridge bridge, BridgeGame bridgeGame) {
        while (gameState == GameState.START) {
            gameState = bridgeGame.move(user, bridge, inputView.readMoving());
            outputView.printMap(user);
            if (gameState == GameState.FAILED || gameState == GameState.RETRY) {
                gameState = bridgeGame.retry(user, inputView.readGameCommand());
            }
        }
        outputView.printResult(user);
    }
}
