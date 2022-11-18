package bridge;

import bridge.model.BridgeGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {

    @DisplayName("현재 입력과 다리 길 일치하는 경우 O 출력")
    @Test
    void moveCorrect() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","U","U"));
        bridgeGame.move("U");
        Assertions.assertEquals(bridgeGame.getUpMove().get(0), " O ");
    }

    @DisplayName("현재 입력과 다리 길 일치하지 않는 경우 X 출력")
    @Test
    void moveNotCorrect() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","U","U"));
        bridgeGame.move("D");
        Assertions.assertEquals(bridgeGame.getDownMove().get(0), " X ");
    }

    @DisplayName("게임 재시작 시 게임 횟수 증가")
    @Test
    void retryGameCnt() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","U","U"));
        bridgeGame.retry("R");
        Assertions.assertEquals(bridgeGame.getGameCnt(), 2);
    }

    @DisplayName("게임 재시작 시 이동 기록된 리스트 초기화")
    @Test
    void retryClearList() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","U","U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.retry("R");
        Assertions.assertEquals(bridgeGame.getUpMove().size(), 0);
        Assertions.assertEquals(bridgeGame.getDownMove().size(), 0);

    }

    @DisplayName("다리 끝까지 갔을 때 게임 종료")
    @Test
    void checkGameIsDone() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","U","U"));
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        Assertions.assertEquals(bridgeGame.checkGameIsDone(), true);

    }
}
