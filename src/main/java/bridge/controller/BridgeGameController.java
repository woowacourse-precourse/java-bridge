package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private int tryCount;

    public void startBridgeGame() {
        OutputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        // TODO:
        //  게임 시작
        playGame();
    }

    public void playGame() {
        String direction = inputView.readMoving();
    }

}
