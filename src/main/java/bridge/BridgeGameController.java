package bridge;

import java.util.List;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame;

    public void gameStart() {
        outputView.printStartMessage();
        initBridge();
        gamePlay();
        outputView.printResult(bridgeGame.getTryCount(), bridgeGame.isSuccess());
    }

    private void initBridge() {
        Bridge bridge = new Bridge(makeBridge());
        bridgeGame = new BridgeGame(bridge);
    }

    private List<String> makeBridge() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private void gamePlay() {
        boolean gameState = true;

        while (gameState) {
            gameMovement();
        }
    }

    private void gameMovement() {
        while (!bridgeGame.isFinish()) {
            outputView.printMap(bridgeGame.move(inputView.readMoving()));
        }
    }
}
