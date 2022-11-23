package bridge.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @Nested
    @DisplayName("다리 길이 검증 로직 테스트")
    class BridgeLength {

        @ParameterizedTest(name = "길이 {0}은 범위를 벗어난 길이로 예외 발생")
        @ValueSource(ints = {1, 2, 21, 22})
        @DisplayName("범위 벗어난 경우")
        void validateBridgeLength(int length) {
            Assertions.assertThatThrownBy(() -> Validator.validateBridgeLength(length))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("입력값 숫자인지 검증 로직 테스트")
    class Numeric {

        @ParameterizedTest(name = "{0}는 숫자가 아니므로 예외 발생")
        @ValueSource(strings = {"R", "가", "-", "*"})
        @DisplayName("숫자가 아닌 경우")
        void validateBridgeLength(String input) {
            Assertions.assertThatThrownBy(() -> Validator.validateStringIsNumeric(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("입력값이 유효한 이동 옵션인지 검증 로직 테스트")
    class ValidMoving {

        @ParameterizedTest(name = "{0}는 유효한 옵션이 아니므로 예외 발생")
        @ValueSource(strings = {"A", "B", "X"})
        @DisplayName("유효한 옵션이 아닌 경우")
        void validateBridgeLength(String input) {
            Assertions.assertThatThrownBy(() -> Validator.validateMovingType(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("입력값 영어인지 검증 로직 테스트")
    class English {

        @ParameterizedTest(name = "{0}는 영어가 아니므로 예외 발생")
        @ValueSource(strings = {"12", "가", "-", "*"})
        @DisplayName("영어가 아닌 경우")
        void validateBridgeLength(String input) {
            Assertions.assertThatThrownBy(() -> Validator.validateStringIsEnglish(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("입력값이 유효한 재시작 옵션인지 검증 로직 테스트")
    class Restart {

        @ParameterizedTest(name = "{0}는 유효한 옵션이 아니므로 예외 발생")
        @ValueSource(strings = {"A", "a", "B", "U"})
        @DisplayName("유효한 옵션이 아닌 경우")
        void validateBridgeLength(String input) {
            Assertions.assertThatThrownBy(() -> Validator.validateRestartOption(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}