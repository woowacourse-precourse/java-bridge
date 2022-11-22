package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BlockStatusTest {
    @CsvSource(value = {"SUCCESS:true", "FAIL:false", "NOT_VISITED:false"}, delimiter = ':')
    @ParameterizedTest
    void SUCCESS인_경우에만_통과했다는_상태를_가진다(BlockStatus status, boolean result) {
        assertThat(status.isPassed()).isEqualTo(result);
    }

    @CsvSource(value = {"SUCCESS:true", "FAIL:true", "NOT_VISITED:false"}, delimiter = ':')
    @ParameterizedTest
    void 방문한_경우만_true를_반환한다(BlockStatus status, boolean result) {
        assertThat(status.isVisited()).isEqualTo(result);
    }
}
