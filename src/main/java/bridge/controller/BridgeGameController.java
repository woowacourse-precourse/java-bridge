package bridge.controller;

import bridge.BridgeGame;
import bridge.domain.BridgeStatus;
import bridge.domain.Direction;
import bridge.domain.PlayerStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startBridgeGame() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        playGame();
    }

    public void playGame() {
        BridgeStatus bridgeStatus = null;
        while(bridgeGame.isPlaying()) {
            Direction direction = inputView.readMoving();
            bridgeStatus = bridgeGame.move(direction);
            outputView.printMap(bridgeStatus);
        }
        retryOrQuit();
        PlayerStatus finalStatus = bridgeGame.getGameStatus();
        outputView.printResult(finalStatus, bridgeStatus);
    }

    public void retryOrQuit() {
        String command = inputView.readGameCommand();
        if(bridgeGame.retry(command)) {
            playGame();
        }
    }
}
