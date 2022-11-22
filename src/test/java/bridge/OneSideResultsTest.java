package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.DownsideResults;
import bridge.domain.OneSideResults;
import bridge.domain.UpsideResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OneSideResultsTest {

    private static final int FIRST_INDEX = 0;

    private OneSideResults upsideResults;
    private OneSideResults downsideResults;

    @BeforeEach
    void setUp() {
        upsideResults = new UpsideResults();
        downsideResults = new DownsideResults();
    }

    void updateBothSidesResults(String currentMove, String matchResult) {
        upsideResults.update(currentMove, matchResult);
        downsideResults.update(currentMove, matchResult);
    }

    void assertBothSidesResults(String expectedUpsideResult, String expectedDownsideResult) {
        assertThat(upsideResults.getResults().get(FIRST_INDEX))
                .isEqualTo(expectedUpsideResult);
        assertThat(downsideResults.getResults().get(FIRST_INDEX))
                .isEqualTo(expectedDownsideResult);
    }

    @DisplayName("플레이어가 위 칸을 건넜을 때 통과하는 경우, 위 칸에 O가 추가되고 아래 칸에는 공백이 추가된다.")
    @Test
    void case1() {
        updateBothSidesResults("U", "O");

        assertBothSidesResults("O", " ");
    }

    @DisplayName("플레이어가 위 칸을 건넜을 때 실패하는 경우, 위 칸에 X가 추가되고 아래 칸에는 공백이 추가된다.")
    @Test
    void case2() {
        updateBothSidesResults("U", "X");

        assertBothSidesResults("X", " ");
    }

    @DisplayName("플레이어가 아래 칸을 건넜을 때 통과하는 경우, 위 칸에 공백이 추가되고 아래 칸에는 O가 추가된다.")
    @Test
    void case3() {
        updateBothSidesResults("D", "O");

        assertBothSidesResults(" ", "O");
    }

    @DisplayName("플레이어가 아래 칸을 건넜을 때 실패하는 경우, 위 칸에 공백이 추가되고 아래 칸에는 X가 추가된다.")
    @Test
    void case4() {
        updateBothSidesResults("D", "X");

        assertBothSidesResults(" ", "X");
    }
    
    @DisplayName("플레이어가 게임을 다시 시작하는 경우, 위 칸의 이동 기록이 전부 사라진다.")
    @Test
    void resetUpsideResult() {
        upsideResults.update("U", "X");
        final int previousSizeOfUpside = upsideResults.getResults().size();
        upsideResults.reset();
        final int currentSizeOfUpside = upsideResults.getResults().size();
        assertThat(previousSizeOfUpside).isEqualTo(1);
        assertThat(currentSizeOfUpside).isEqualTo(0);
    }

    @DisplayName("플레이어가 게임을 다시 시작하는 경우, 아래 칸의 이동 기록이 전부 사라진다.")
    @Test
    void resetDownsideResult() {
        downsideResults.update("D", "X");
        final int previousSizeOfDownside = downsideResults.getResults().size();
        downsideResults.reset();
        final int currentSizeOfDownside = downsideResults.getResults().size();
        assertThat(previousSizeOfDownside).isEqualTo(1);
        assertThat(currentSizeOfDownside).isEqualTo(0);
    }
}