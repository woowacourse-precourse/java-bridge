package bridge.domain.state;

import bridge.domain.MoveResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void retryState() {
        assertThat(new Success(List.of()).isMoveFail()).isFalse();
    }
}