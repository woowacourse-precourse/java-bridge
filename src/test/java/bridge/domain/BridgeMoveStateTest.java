package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMoveStateTest {

    private final BridgeMoveState moveState = new BridgeMoveState();

    @DisplayName("윗 칸 이동 상태 업데이트 확인")
    @CsvSource(value = {"true, O", "false, X"})
    @ParameterizedTest
    void checkUpdateUpState(boolean canMove, String expected) {
        moveState.update("U", canMove);
        List<String> upState = moveState.getUpState();
        assertThat(upState).isEqualTo(List.of(expected));
    }

    @DisplayName("아래 칸 이동 상태 업데이트 확인")
    @CsvSource(value = {"true, O", "false, X"})
    @ParameterizedTest
    void checkUpdateDownState(boolean canMove, String expected) {
        moveState.update("D", canMove);
        List<String> downState = moveState.getDownState();
        assertThat(downState).isEqualTo(List.of(expected));
    }
}
