package bridge;

import java.util.List;

public class BridgeGameManager {
    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    BridgeGameManager() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = createBridgeGame();
    }

    public BridgeGame createBridgeGame() {
        outputView.printBeforeGame();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        return bridgeGame;
    }

    public void run() {
        while (!bridgeGame.isFinished()) {
            boolean roundResult = oneRound();
            if (roundResult) {
                continue;
            }
            if (inputView.readGameCommand().equals(GameCommandEnum.Q.name())) {
                break;
            }
            bridgeGame.retry();
        }
        outputView.printResult(bridgeGame);
    }

    private boolean oneRound() {
        String moving = inputView.readMoving();
        boolean movingResult = bridgeGame.move(moving);
        outputView.printMap(bridgeGame);
        return movingResult;
    }
}
