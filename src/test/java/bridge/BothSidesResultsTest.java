package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BothSidesResultsTest {
    private OneSideResults upsideResults;
    private OneSideResults downsideResults;

    @BeforeEach
    void setUp() {
        upsideResults = new UpsideResults();
        downsideResults = new DownsideResults();
    }

    @DisplayName("사용자가 위 칸을 건넜을 때 통과하는 경우, 위 칸에 O가 추가되고 아래 칸에는 blank가 추가된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:O:blank"}, delimiter = ':')
    void case1(String currentMove, String moveResult, String blank) {
        upsideResults.updateResults(currentMove, moveResult, blank);
        downsideResults.updateResults(currentMove, moveResult, blank);

        assertThat(upsideResults.getResults().get(0)).isEqualTo("O");
        assertThat(downsideResults.getResults().get(0)).isEqualTo("blank");
    }

    @DisplayName("사용자가 아래 칸을 건넜을 때 실패하는 경우, 위 칸에 blank가 추가되고 아래 칸에는 X가 추가된다.")
    @ParameterizedTest
    @CsvSource(value = {"D:X:blank"}, delimiter = ':')
    void case2(String currentMove, String moveResult, String blank) {
        upsideResults.updateResults(currentMove, moveResult, blank);
        downsideResults.updateResults(currentMove, moveResult, blank);

        assertThat(upsideResults.getResults().get(0)).isEqualTo("blank");
        assertThat(downsideResults.getResults().get(0)).isEqualTo("X");
    }
}