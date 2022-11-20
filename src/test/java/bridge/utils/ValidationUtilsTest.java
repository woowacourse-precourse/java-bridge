package bridge.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사용자의 입력을 검증한다.")
class ValidationUtilsTest {

    @Nested
    @DisplayName("입력되는 다리 크기의 값을 검증한다.")
    class inputBridgeSizeTest {
        @DisplayName("아무것도 입력이 안되면 오류가 발생된다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", ""})
        void throwExceptionWhenInputNoting(String input) {
            assertThatThrownBy(() -> ValidationUtils.validateBridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("3이상 20이하의 숫자가 아니면 오류가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"-1", "0", "2", "21", "100"})
        void throwExceptionWhenInputWrongNumber(String input) {
            assertThatThrownBy(() -> ValidationUtils.validateBridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자가 아닌 입력이 주어지면 오류가 발생된다.")
        @ParameterizedTest
        @ValueSource(strings = {"-1a", "z0", "b2", "2o1", "1p0t0"})
        void throwExceptionWhenInputCharacter(String input) {
            assertThatThrownBy(() -> ValidationUtils.validateBridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}