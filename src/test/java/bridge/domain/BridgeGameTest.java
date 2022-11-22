package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final List<String> bridge = List.of("U", "D", "U");

    @Nested
    class MoveTest {

        @DisplayName("첫번째 칸이 갈수 있는 칸이고 그 칸을 선택했을 때")
        @Test
        void case1() {
            String testSelectBridge = "U";
            int testIdx = 0;
            boolean answer = true;
            bridgeGame.move(testSelectBridge, testIdx, bridge);
            assertEquals(answer, bridgeGame.getCanMove());
        }

        @DisplayName("두번째 칸이 갈 수 없는 칸이고 그 칸을 선택 했을 때")
        @Test
        void case2() {
            String testSelectBridge = "U";
            int testIdx = 1;
            boolean answer = false;
            bridgeGame.move(testSelectBridge, testIdx, bridge);
            assertEquals(answer, bridgeGame.getCanMove());
        }

        @DisplayName("세번째 칸이 갈 수 없는 칸이고 그 칸을 선택 했을 때")
        @Test
        void case3() {
            String testSelectBridge = "D";
            int testIdx = 2;
            boolean answer = false;
            bridgeGame.move(testSelectBridge, testIdx, bridge);
            assertEquals(answer, bridgeGame.getCanMove());
        }
    }

    @Nested
    class RetryTest {

        @DisplayName("다시 시작한다는 R 을 입력 했을때 true 나오는지 확인")
        @Test
        void case1() {
            String testRetry = "R";
            boolean answer = true;
            bridgeGame.retry(testRetry);
            assertEquals(answer, bridgeGame.getDoRetry());
        }

        @DisplayName("끝낸다는 Q 를 입력 했을때 false 나오는지 확인")
        @Test
        void case2() {
            String testRetry = "Q";
            boolean answer = false;
            bridgeGame.retry(testRetry);
            assertEquals(answer, bridgeGame.getDoRetry());
        }
    }

}