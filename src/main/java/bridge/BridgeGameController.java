package bridge;

import java.util.List;

public class BridgeGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private int tryCount = 1;

    public void startBridgeGame() {

        outputView.printStart();
        int size = inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        playBridgeGame(bridgeMaker.makeBridge(size));
    }

    private void playBridgeGame(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame();
        boolean finish = false;
        while (!finish) {
            bridgeGame.move(inputView.readMoving(), bridge);
            outputView.printMap(bridgeGame, bridge);
            if (!bridgeGame.isCorrect) {
                finish = finishBridgeGame(bridgeGame);
            }
            if (bridgeGame.isCorrect && bridgeGame.moveCount == bridge.size()) {
                finish = true;
            }
        }
        outputView.printResult(bridgeGame, bridge, tryCount);
    }

    private boolean finishBridgeGame(BridgeGame bridgeGame) {
        if (inputView.readGameCommand()) {
            return true;
        }
        bridgeGame.retry();
        tryCount++;
        return false;
    }
}
