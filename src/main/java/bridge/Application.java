package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        try {
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.move(1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
