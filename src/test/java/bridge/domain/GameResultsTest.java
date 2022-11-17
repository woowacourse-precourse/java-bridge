package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultsTest {

    private final GameResults gameResults = new GameResults();

    @BeforeEach
    void init() {
        gameResults.reset();
    }

    @ParameterizedTest(name = "{0}, {1}을 입력 받으면 upResult에는 {1}가, downResults에는 공백이 저장된다.")
    @CsvSource({"U,O", "U,X"})
    void addResultsUp(String moveCommand, String resultSign) {
        gameResults.addResults(moveCommand, resultSign);
        assertThat(gameResults.upResults()).contains(resultSign);
        assertThat(gameResults.downResults()).contains(" ");
    }

    @ParameterizedTest(name = "{0}, {1}을 입력 받으면 upResult에는 공백이, downResults에는 {1}가 저장된다.")
    @CsvSource({"D,O", "D,X"})
    void addResultsDown(String moveCommand, String resultSign) {
        gameResults.addResults(moveCommand, resultSign);
        assertThat(gameResults.upResults()).contains(" ");
        assertThat(gameResults.downResults()).contains(resultSign);
    }

    @DisplayName("reset 메서드는 upResult와 downResult를 전부 비운다.")
    @Test
    void reset() {
        gameResults.addResults("U", "O");
        gameResults.reset();
        assertThat(gameResults.upResults()).isEmpty();
        assertThat(gameResults.downResults()).isEmpty();
    }
}