package bridge.domain;

import static bridge.utils.Constant.DOWN;
import static bridge.utils.Constant.UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.utils.validator.BridgeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveTest {

    @DisplayName("현재 다리와 이동 비교 후 결과 저장")
    @Test
    void createMoveResult() {
        Move move = new Move(UP);
        boolean SuccessResult = move.makeMoveResult(UP);
        boolean FailResult = move.makeMoveResult(DOWN);

        assertThat(SuccessResult).isEqualTo(true);
        assertThat(FailResult).isEqualTo(false);
    }

}
