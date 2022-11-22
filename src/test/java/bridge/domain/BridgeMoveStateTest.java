package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMoveStateTest {

    private final BridgeMoveState moveState = new BridgeMoveState();

    @DisplayName("이동 상태 업데이트 확인")
    @CsvSource(value = {"true", "false"})
    @ParameterizedTest
    void checkUpdateUpState(boolean canMove) {
        moveState.update(canMove);
        List<Boolean> state = moveState.getState();
        assertThat(state).isEqualTo(List.of(canMove));
    }

    @DisplayName("이동 횟수를 구한다.")
    @CsvSource(value = {"1", "2", "3", "5"})
    @ParameterizedTest
    void checkMoveCount(int count) {
        for (int i = 1; i <= count; i++) {
            moveState.update(true);
        }
        int actual = moveState.getMoveCount();
        assertThat(actual).isEqualTo(count);
    }

    @DisplayName("마지막 이동 상태를 구한다.")
    @CsvSource(value = {"true", "false"})
    @ParameterizedTest
    void checkLastState(boolean lastState) {
        moveState.update(true);
        moveState.update(lastState);
        boolean actual = moveState.getLastState();
        assertThat(actual).isEqualTo(lastState);
    }
}
