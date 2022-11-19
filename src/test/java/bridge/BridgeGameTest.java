package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static bridge.GameStatus.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BridgeGameTest {
    List<String> bridge = List.of("U", "U", "U", "U", "U", "U", "U");
    BridgeGame bridgeGame;

    @BeforeEach
    void setBridgeGame() {
        bridgeGame = new BridgeGame(
                bridge
        );
    }

    @Test
    @DisplayName("초기값 테스트")
    void initTest() {
        assertEquals(bridgeGame.getStatus(), PLAYING);
        assertEquals(bridgeGame.getTryCount(), 1);
    }

    @DisplayName("U, D가 아닌 다른값이면 예외")
    @ParameterizedTest(name = "입력이 {0}이면 예외")
    @CsvSource({"1", "2", "u", "d", "hello world"})
    void moveTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            bridgeGame.move(input);
        });
    }

    @Nested
    @DisplayName("진행상테 테스트")
    class gameStatusTest {
        @Test
        @DisplayName("떨여졌을 때 상태는 LOSE")
        void loseTest() {
            bridgeGame.move("D");
            assertEquals(bridgeGame.getStatus(), LOSE);
        }

        @Test
        @DisplayName("게임 진행중인 상태는 PLAYING")
        void playingTest() {
            for (int i = 0; i < bridge.size(); i++) {
                assertEquals(bridgeGame.getStatus(), PLAYING);
                bridgeGame.move("U");
            }
        }

        @Test
        @DisplayName("끝까지 도달했을 때 상태는 WIN")
        void winTest() {
            for (int i = 0; i < bridge.size(); i++) {
                bridgeGame.move("U");
            }
            assertEquals(bridgeGame.getStatus(), WIN);
        }
    }

    @ParameterizedTest(name = "{0}번 재시작 시 재시작횟수는 {1}번")
    @CsvSource({"1:2", "3:4", "6:7"})
    void retryCountTest(int count, int result) {
        for (int i = 0; i < count; i++) {
            bridgeGame.retry();
        }
        assertEquals(bridgeGame.getTryCount(), result);
    }

}