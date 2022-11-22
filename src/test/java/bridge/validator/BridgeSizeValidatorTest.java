package bridge.validator;

import static bridge.validator.ErrorStatus.BRIDGE_SIZE_BLANK_ERROR;
import static bridge.validator.ErrorStatus.BRIDGE_SIZE_RANGE_ERROR;
import static bridge.validator.ErrorStatus.BRIDGE_SIZE_TYPE_ERROR;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeSizeValidatorTest {

    private final BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();

    @DisplayName("정수가 아닌 입력값에 대하여 알맞은 예외를 반환한다.")
    @ValueSource(strings = {"-1", "0.3", "1.2345"})
    @ParameterizedTest
    void isReturnRightExceptionWithInvalidTypeInput(String input) {
        Assertions.assertThatThrownBy(() -> bridgeSizeValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(BRIDGE_SIZE_TYPE_ERROR.getMessage());
    }

    @DisplayName("범위에 맞지 않는 입력값에 대하여 알맞은 예외를 반환한다.")
    @ValueSource(strings = {"0", "300", "26", "2"})
    @ParameterizedTest
    void isReturnRightExceptionWithInvalidRangeInput(String input) {
        Assertions.assertThatThrownBy(() -> bridgeSizeValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BRIDGE_SIZE_RANGE_ERROR.getMessage());
    }

    @DisplayName("빈 입력값에 대하여 알맞은 예외를 반환한다.")
    @ValueSource(strings = {"", "  ", "        "})
    @ParameterizedTest
    void isReturnRightExceptionWithBlankInput(String input) {
        Assertions.assertThatThrownBy(() -> bridgeSizeValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BRIDGE_SIZE_BLANK_ERROR.getMessage());
    }

    @DisplayName("유효한 입력값에 대하여 유효성 검사가 통과한다.")
    @ValueSource(strings = {"3", "20", "15"})
    @ParameterizedTest
    void isReturnNoExceptionWithValidInput(String input) {
        Assertions.assertThatNoException().isThrownBy(() -> bridgeSizeValidator.validate(input));
    }
}
