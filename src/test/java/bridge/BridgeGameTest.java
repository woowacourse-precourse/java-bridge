package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;
    List<String> bridge;

    @BeforeEach
    void setting() {
        bridge = List.of("U", "U", "D");
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("다리 건너기 중 성공 여부 테스트")
    @Test
    void moveTest() {
        bridgeGame.move("U");
        Assertions.assertThat(bridgeGame.succeedMove()).isTrue();

        bridgeGame.move("D");
        Assertions.assertThat(bridgeGame.succeedMove()).isFalse();
    }

    @DisplayName("재시작 여부 확인 테스트")
    @Test
    void retryTest() {
        Assertions.assertThat(bridgeGame.retry("R")).isTrue();
        Assertions.assertThat(bridgeGame.retry("Q")).isFalse();

    }

    @DisplayName("재시작 횟수 테스트")
    @ValueSource(ints = {10, 40, 1, 2})
    @ParameterizedTest
    void totalGameCountTest(int input) {
        for (int cnt = 0; cnt < input; cnt++) {
            bridgeGame.retry("R");
        }

        Assertions.assertThat(bridgeGame.getTotalGameCount()).isEqualTo(input + 1);
    }

    @DisplayName("다리 건너기 성공 테스트")
    @Test
    void isGameEndTest() {
        Assertions.assertThat(bridgeGame.isGameEnd()).isFalse();

        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");

        Assertions.assertThat(bridgeGame.isGameEnd()).isTrue();
    }
}