package bridge.controller;

import bridge.BridgeGame;
import bridge.domain.BridgeStatus;
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
        while(bridgeGame.isNotFinished()) {
            String direction = inputView.readMoving();
            BridgeStatus bridgeStatus = bridgeGame.move(direction);
        }
    }

}
