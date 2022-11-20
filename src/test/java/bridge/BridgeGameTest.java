package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("이동 성공 테스트")
    @ParameterizedTest
    @CsvSource({"U, U", "F, F"})
    void moveSuccess(String moving, String block) {
        assertThat(bridgeGame.move(moving, block)).isTrue();
    }

    @DisplayName("이동 실패 테스트")
    @ParameterizedTest
    @CsvSource({"U, F", "F, U"})
    void moveFail(String moving, String block) {
        assertThat(bridgeGame.move(moving, block)).isFalse();
    }
}