package bridge;

import static org.assertj.core.api.Assertions.*;

import bridge.enums.InputExceptionConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    private final Validator validator = new Validator();

    @ParameterizedTest
    @ValueSource(ints = {1, -2, 50})
    @DisplayName("범위 외의 숫자가 들어오면 예외를 발생한다.")
    void inputOutOfRangeNumber(int input) {
        assertThatThrownBy(() -> validator.isInRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputExceptionConstants.BRIDGE_RANGE.getMessage());
    }


    @ParameterizedTest
    @ValueSource(strings = {" ", "sts", "9.9"})
    @DisplayName("정수가 아니면 예외를 발생한다.")
    void inputNoneInteger(String input) {
        assertThatThrownBy(() -> validator.isNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputExceptionConstants.NONE_NUMERIC.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q", "23"})
    @DisplayName("이동 명령과 관계없는 문자열이 입력될경우 예외를 발생시킨다.")
    void inputNoneMoveCommand(String input) {
        assertThatThrownBy(() -> validator.isMoveCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputExceptionConstants.MOVE_COMMAND.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"D", "U", "23"})
    @DisplayName("게임 명령과 관계 없는 문자열이 입력될 경우 예외를 발생시킨다.")
    void inputNoneGameCommand(String input) {
        assertThatThrownBy(() -> validator.isGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputExceptionConstants.GAME_COMMAND.getMessage());
    }
}