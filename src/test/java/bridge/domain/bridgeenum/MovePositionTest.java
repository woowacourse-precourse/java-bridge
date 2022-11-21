package bridge.domain.bridgeenum;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.errorenum.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovePositionTest {
    private static final String ERROR_HEAD = "[ERROR]";

    @DisplayName("플레이어가 입력한 이동할 칸이 정해진 값이 아니라면 예외가 발생한다")
    @Test
    void createInputWithWrongValue() {
        String inputPosition = "A";

        assertThatThrownBy(() -> MovePosition.validateNextMove(inputPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_IN_MOVE_POSITION.printMessage())
                .hasMessageStartingWith(ERROR_HEAD);
    }

    @DisplayName("플레이어가 입력한 값이 정해진 값이라면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void createInputWithRightValue(String inputPosition) {
        MovePosition.validateNextMove(inputPosition);

        //then: pass test
    }
}
