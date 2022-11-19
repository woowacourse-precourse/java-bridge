package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        try {
            System.out.println("다리 건너기 게임을 시작합니다.");
            bridgeGame.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
