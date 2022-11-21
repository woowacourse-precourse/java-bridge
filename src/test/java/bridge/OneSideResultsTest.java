package bridge;

import static bridge.util.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OneSideResultsTest {
    private OneSideResults upsideResults;
    private OneSideResults downsideResults;

    @BeforeEach
    void setUp() {
        upsideResults = new UpsideResults();
        downsideResults = new DownsideResults();
    }

    void updateBothSidesResults(String currentMove, String moveResult) {
        upsideResults.update(currentMove, moveResult);
        downsideResults.update(currentMove, moveResult);
    }

    @DisplayName("사용자가 위 칸을 건넜을 때 통과하는 경우, 위 칸에 O가 추가되고 아래 칸에는 공백이 추가된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:O"}, delimiter = COLON)
    void case1(String currentMove, String moveResult) {
        updateBothSidesResults(currentMove, moveResult);

        assertThat(upsideResults.getResults().get(0)).isEqualTo("O");
        assertThat(downsideResults.getResults().get(0)).isEqualTo(" ");
    }

    @DisplayName("사용자가 위 칸을 건넜을 때 실패하는 경우, 위 칸에 X가 추가되고 아래 칸에는 공백이 추가된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:X"}, delimiter = COLON)
    void case2(String currentMove, String moveResult) {
        updateBothSidesResults(currentMove, moveResult);

        assertThat(upsideResults.getResults().get(0)).isEqualTo("X");
        assertThat(downsideResults.getResults().get(0)).isEqualTo(" ");
    }

    @DisplayName("사용자가 아래 칸을 건넜을 때 통과하는 경우, 위 칸에 공백이 추가되고 아래 칸에는 O가 추가된다.")
    @ParameterizedTest
    @CsvSource(value = {"D:O"}, delimiter = COLON)
    void case3(String currentMove, String moveResult) {
        updateBothSidesResults(currentMove, moveResult);

        assertThat(upsideResults.getResults().get(0)).isEqualTo(" ");
        assertThat(downsideResults.getResults().get(0)).isEqualTo("O");
    }

    @DisplayName("사용자가 아래 칸을 건넜을 때 실패하는 경우, 위 칸에 공백이 추가되고 아래 칸에는 X가 추가된다.")
    @ParameterizedTest
    @CsvSource(value = {"D:X"}, delimiter = COLON)
    void case4(String currentMove, String moveResult) {
        updateBothSidesResults(currentMove, moveResult);

        assertThat(upsideResults.getResults().get(0)).isEqualTo(" ");
        assertThat(downsideResults.getResults().get(0)).isEqualTo("X");
    }
}