package bridge.controller;

import bridge.service.BridgeGame;

/**
 * 다리 건너기 게임을 실행하는 클래스
 */
public class BridgeGameController {

    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame();
    }

    public void gameStart() {
        run();
        while (!this.bridgeGame.isWin()) {
            if (!this.bridgeGame.retry()) {
                break;
            }
            run();
        }
        this.bridgeGame.finish();
    }

    private void run() {
        while (!this.bridgeGame.isDone()) {
            this.bridgeGame.move();
        }
    }
}
