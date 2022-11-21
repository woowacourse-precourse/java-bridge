package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        try {
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.playGame();
        }catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
