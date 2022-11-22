package bridge;

import static org.assertj.core.api.Assertions.*;

import bridge.enums.InputExceptionConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    private final Validator validator = new Validator();


    @ParameterizedTest
    @ValueSource(strings = {" ", "sts", "9.9"})
    @DisplayName("정수가 아니면 예외를 발생한다.")
    void inputNoneInteger(String input) {
        assertThatThrownBy(() -> validator.isNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputExceptionConstants.NONE_NUMERIC.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, -2, 50})
    @DisplayName("범위 외의 숫자가 들어오면 예외를 발생한다.")
    void inputOutOfRangeNumber(int input) {
        assertThatThrownBy(() -> validator.isInRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputExceptionConstants.BRIDGE_RANGE.getMessage());
    }



}