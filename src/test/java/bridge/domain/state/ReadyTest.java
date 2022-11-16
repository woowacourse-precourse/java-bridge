package bridge.domain.state;

import bridge.domain.MoveResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReadyTest {
    @Test
    @DisplayName("Ready 상태 반환하기")
    void stateInformation() {
        assertThat(new Ready().state()).isEqualTo(MoveResult.READY);
    }
}
