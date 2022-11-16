package bridge.domain.state;

import bridge.domain.MoveResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FailTest {
    @Test
    @DisplayName("Fail 상태 반환하기")
    void stateInformation() {
        assertThat(new Fail(List.of()).state()).isEqualTo(MoveResult.FAIL);
    }
    
    @Test
    @DisplayName("재시도 여부 선택 상태 맞음")
    void isRetry() {
        assertThat(new Fail(List.of()).isMoveFail()).isTrue();
    }
    
    @Test
    @DisplayName("게임 종료 상태 아님")
    void isGameFinished() {
        assertThat(new Fail(List.of("U", "D", "U")).isGameFinished(2)).isFalse();
    }
}