package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameOtherTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        bridgeGame.move("U", "U");
        bridgeGame.move("F", "F");
        bridgeGame.move("F", "U");
    }

    @DisplayName("이동 기록 찾기 테스트")
    @ParameterizedTest
    @CsvSource({"0, U", "1, F", "2, F"})
    void findMovingByIndexTest(int index, String moving) {
        assertThat(bridgeGame.findMovingByIndex(index)).isEqualTo(moving);
    }

    @DisplayName("이동 결과 찾기 테스트")
    @ParameterizedTest
    @CsvSource({"0, true", "1, true", "2, false"})
    void findMovingResultByIndexTest(int index, boolean result) {
        assertThat(bridgeGame.findMovingResultByIndex(index)).isEqualTo(result);
    }
}