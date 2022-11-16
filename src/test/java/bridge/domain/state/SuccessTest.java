package bridge.domain.state;

import bridge.domain.MoveResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SuccessTest {
    @Test
    @DisplayName("Success 상태 반환하기")
    void stateInformation() {
        assertThat(new Success(List.of()).state()).isEqualTo(MoveResult.SUCCESS);
    }
    
    @Test
    @DisplayName("재시도 여부 선택 상태 아님")
    void isRetry() {
        assertThat(new Success(List.of()).isMoveFail()).isFalse();
    }
    
    @DisplayName("게임 종료 상태 체크")
    @ParameterizedTest(name = "{displayName} : numberOfMoves => {0}, result => {1}")
    @CsvSource(value = {"2, true", "1, false"})
    void isGameFinished(final int numberOfMoves, final boolean result) {
        assertThat(new Success(List.of("U", "D", "U")).isGameFinished(numberOfMoves)).isEqualTo(result);
    }
}