package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void move() {
        List<String> bridgeMovedHistory = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(new GameStatus(), bridgeMovedHistory, 4);
        List<String> bridgeMoved = bridgeGame.move("U");

        assertThat(bridgeMoved).containsExactly("U", "D", "U", "U");
    }

    @Test
    void retry() {
        List<String> bridgeMovedHistory = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(new GameStatus(), bridgeMovedHistory, 4);
        boolean retryStatus = bridgeGame.retry("R");

        assertThat(retryStatus).isTrue();
    }

    @Test
    void isMovable() {
        List<String> bridgeMovedHistory = List.of("U", "D", "U", "D");
        BridgeGame bridgeGame = new BridgeGame(new GameStatus(), bridgeMovedHistory, 4);

        System.out.println("내가 이동한 다리 칸 : " + bridgeGame.getBridgeMoved());
        System.out.println("실제 이동할 수 있는 다리 칸 :" + bridgeGame.getCorrectBridge());

        for (int i = 0; i < 4; i++) {
            System.out.print(bridgeGame.isMovable(i) + " ");
        }
        System.out.println();
    }

    @Test
    void decideBridgeValues() {
        List<String> bridgeMovedHistory = List.of("U", "D", "U", "D");
        BridgeGame bridgeGame = new BridgeGame(new GameStatus(), bridgeMovedHistory, 4);

        System.out.println("내가 이동한 다리 칸 :\t" + bridgeGame.getBridgeMoved());
        System.out.println("이동 가능한 다리 칸 :\t" + bridgeGame.getCorrectBridge());

        List<List<String>> bridgeValues = bridgeGame.decideBridgeValues();

        System.out.println("다리 위 칸의 값들 :\t" + bridgeValues.get(0));
        System.out.println("다리 아래 칸의 값들 :\t" + bridgeValues.get(1));
    }
}