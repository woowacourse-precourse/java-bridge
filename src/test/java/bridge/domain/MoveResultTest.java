package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoveResultTest {
    @DisplayName("성공인지 아닌지 확인")
    @ParameterizedTest(name = "{displayName} : moveResult => {0}, expected => {1}")
    @CsvSource(value = {"SUCCESS, true", "FAIL, false"})
    void isSuccess(final MoveResult moveResult, final boolean expected) {
        assertThat(moveResult.isSuccess()).isEqualTo(expected);
    }
}