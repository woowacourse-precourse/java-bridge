package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputBridgeSizeValidatorTest {

    @DisplayName("다리 길이가 3 이상 20 이하 범위 밖의 숫자일 경우 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 1, 21, 100})
    @ParameterizedTest
    void validateInvalidBridgeSize(Integer input) {
        assertThatThrownBy(() -> InputBridgeSizeValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}