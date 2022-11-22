package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @DisplayName("boolean값에 맞는 결과(기호) 가져오는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true,O", "false,X"})
    void getMovingResultByTest(boolean isMovable, String expected) {
        assertThat(GameResult.getMovingResultBy(isMovable)).isEqualTo(expected);
    }

    @DisplayName("boolean값에 맞는 결과(성공/실패) 가져오는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true,성공", "false,실패"})
    void getGameResultByTest(boolean isSucceeded, String expected) {
        assertThat(GameResult.getGameResultBy(isSucceeded)).isEqualTo(expected);
    }

}
