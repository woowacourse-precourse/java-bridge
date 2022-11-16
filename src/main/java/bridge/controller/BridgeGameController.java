package bridge.controller;

import bridge.service.BridgeGame;

/**
 * 다리 건너기 게임을 실행하는 클래스
 */
public class BridgeGameController {

    private final BridgeGame BRIDGE_GAME;

    public BridgeGameController() {
        this.BRIDGE_GAME = new BridgeGame();
    }

    public void gameStart() {
        do {
            while (!this.BRIDGE_GAME.isDone()) {
                this.BRIDGE_GAME.move();
            }
        } while (this.BRIDGE_GAME.retry());
    }
}
