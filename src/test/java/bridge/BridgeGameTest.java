package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("이동할 칸을 건널 수 있으면 O를 반환")
    @ParameterizedTest
    @CsvSource(value = {"U:U:O", "D:D:O"}, delimiter = ':')
    void correctMoving(String playerMove, String answerMove, String expected) {
        assertThat(bridgeGame.move(playerMove, answerMove)).isEqualTo(expected);
    }

    @DisplayName("이동할 칸을 건널 수 없으면 X를 반환")
    @ParameterizedTest
    @CsvSource(value = {"U:D:X", "D:U:X"}, delimiter = ':')
    void incorrectMoving(String playerMove, String answerMove, String expected) {
        assertThat(bridgeGame.move(playerMove, answerMove)).isEqualTo(expected);
    }
}