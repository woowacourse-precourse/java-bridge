package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    List<String> bridge = List.of("U", "U", "U");
    List<String> userBridge = List.of("U", "U", "D");
    BridgeGame bridgeGame = new BridgeGame(bridge);

    @DisplayName("사용자가 이동할 수 있는지 확인")
    @Test
    void testMove() {
        assertTrue(bridgeGame.move(userBridge.get(0), 0).contains(" O "));
        assertFalse(bridgeGame.move(userBridge.get(0), 0).contains(" X "));
        assertTrue(bridgeGame.move(userBridge.get(2), 2).contains(" X "));
    }

    @DisplayName("사용자가 2번 이상 이동 시 연속하여 출력되는지 확인")
    @Test
    void test2TurnMove() {
        assertThat(bridgeGame.move(userBridge.get(1), 1).contains(" | "));
    }

    @DisplayName("Bridge Game 재시작 시 result 초기화 확인")
    @Test
    void testRetry() {
        bridgeGame.result = List.of("U","D");
        bridgeGame.retry();

        assertTrue(bridgeGame.result.equals(List.of()));
    }

    @DisplayName("Bridge Game 재시작 시 실행 횟수 1회 추가 확인")
    @Test
    void testMatchNum() {
        bridgeGame.result = List.of("U","D");
        bridgeGame.retry();

        assertTrue(bridgeGame.matchNum==2);
    }
}