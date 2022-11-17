package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.MoveResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoveResultsTest {

    private final MoveResults moveResults = new MoveResults();

    @BeforeEach
    void init() {
        moveResults.reset();
    }

    @ParameterizedTest(name = "{0}, {1}을 입력 받으면 upResult에는 {1}가, downResults에는 공백이 저장된다.")
    @CsvSource({"U,O", "U,X"})
    void addResultsUp(String moveCommand, String resultSign) {
        moveResults.addResults(moveCommand, resultSign);
        assertThat(moveResults.upResults()).contains(resultSign);
        assertThat(moveResults.downResults()).contains(" ");
    }

    @ParameterizedTest(name = "{0}, {1}을 입력 받으면 upResult에는 공백이, downResults에는 {1}가 저장된다.")
    @CsvSource({"D,O", "D,X"})
    void addResultsDown(String moveCommand, String resultSign) {
        moveResults.addResults(moveCommand, resultSign);
        assertThat(moveResults.upResults()).contains(" ");
        assertThat(moveResults.downResults()).contains(resultSign);
    }

    @DisplayName("reset 메서드는 upResult와 downResult를 전부 비운다.")
    @Test
    void reset() {
        moveResults.addResults("U", "O");
        moveResults.reset();
        assertThat(moveResults.upResults()).isEmpty();
        assertThat(moveResults.downResults()).isEmpty();
    }
}