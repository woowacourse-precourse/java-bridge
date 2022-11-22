package bridge;

import static bridge.util.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("이동할 칸을 건널 수 있으면 O를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"U:U:O", "D:D:O"}, delimiter = COLON)
    void correctMove(String playerMove, String answerMove, String expectedMatchResult) {
        assertThat(bridgeGame.move(playerMove, answerMove)).isEqualTo(expectedMatchResult);
    }

    @DisplayName("이동할 칸을 건널 수 없으면 X를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"U:D:X", "D:U:X"}, delimiter = COLON)
    void wrongMove(String playerMove, String answerMove, String expected) {
        assertThat(bridgeGame.move(playerMove, answerMove)).isEqualTo(expected);
    }

    @DisplayName("게임을 다시 시작할 경우 시도 횟수가 1 증가한다.")
    @Test
    void increaseTrialCount() {
        final int beforeTrialCount = bridgeGame.getTotalTrialCount();
        bridgeGame.retry();
        final int afterTrialCount = bridgeGame.getTotalTrialCount();

        assertThat(afterTrialCount - beforeTrialCount).isEqualTo(1);
    }

    @DisplayName("게임을 종료할 경우 실패를 반환한다.")
    @Test
    void returnFailure() {
        bridgeGame.quit();
        final String finalResult = bridgeGame.getFinalResult();

        assertThat(finalResult).isEqualTo("실패");
    }
}