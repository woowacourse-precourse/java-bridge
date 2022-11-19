package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.constant.ConstValue.QUIT;

public class GameController {
    private final BridgeGame bridgeGame;

    public GameController() {
        this.bridgeGame = new BridgeGame();
    }

    public void play() {
        do {
            bridgeGame.move();
        } while (!bridgeGame.isQuit());
    }

}
