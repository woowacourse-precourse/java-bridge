package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {

    @DisplayName("다리 길이 일치하는 경우 O 출력")
    @Test
    void moveCorrect() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","U","U"));
        bridgeGame.move("U");
        Assertions.assertEquals(bridgeGame.getUpperMove().get(0), " O ");
    }

    @DisplayName("다리 길이와 일치하지 않는 경우 X 출력")
    @Test
    void moveNotCorrect() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","U","U"));
        bridgeGame.move("D");
        Assertions.assertEquals(bridgeGame.getLowerMove().get(0), " X ");
    }

    @DisplayName("재시작 시 횟수 증가")
    @Test
    void retryGameCnt() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","U","U"));
        bridgeGame.retry("R");
        Assertions.assertEquals(bridgeGame.getGameCount(), 2);
    }

    @DisplayName("재시작할 때 기록 초기화")
    @Test
    void retryClearList() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","U","U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.retry("R");
        Assertions.assertEquals(bridgeGame.getUpperMove().size(), 0);
        Assertions.assertEquals(bridgeGame.getLowerMove().size(), 0);

    }

    @DisplayName("완주했을 때 게임 종료")
    @Test
    void checkGameIsDone() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","U","U"));
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        Assertions.assertTrue(bridgeGame.isCheckGame());
    }
}
