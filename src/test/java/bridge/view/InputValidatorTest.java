package bridge.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사용자 입력 검증 테스트")
class InputValidatorTest {
    @Nested
    @DisplayName("다리 길이 입력에 대한 검증 테스트")
    class ValidateSizeTest {
        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"eng", "한글", "!", "3.5"})
        @NullAndEmptySource
        @DisplayName("사용자 입력이 자연수가 아니면 예외가 발생한다.")
        void toNumber_SizeIsNotNumeric_ExceptionThrown(String input) {
            assertThatThrownBy(() -> new InputValidator().validateSize(input))
                    .isInstanceOf(NumberFormatException.class);
        }

        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"2", "21"})
        @DisplayName("사용자 입력이 3과 20 사이의 자연수가 아니면 예외가 발생한다.")
        void validateRangeOfSize_SizeIsNotNumeric_ExceptionThrown(String input) {
            assertThatThrownBy(() -> new InputValidator().validateSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("이동할 칸 입력에 대한 검증 테스트")
    class ValidateMovingTest {
        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"u", "d", "A", "0"})
        @EmptySource
        @DisplayName("사용자 입력이 U 또는 D가 아니면 예외가 발생한다.")
        void validateMoving_InputIsNotUAndD_ExceptionThrown(String input) {
            assertThatThrownBy(() -> new InputValidator().validateMoving(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("재시작 여부 입력에 대한 검증 테스트")
    class ValidateGameCommandTest {
        @ParameterizedTest(name = "입력값 -> {0}")
        @ValueSource(strings = {"r", "q", "U", "0"})
        @EmptySource
        @DisplayName("사용자 입력이 R 또는 Q가 아니면 예외가 발생한다.")
        void validateMoving_InputIsNotUAndD_ExceptionThrown(String input) {
            assertThatThrownBy(() -> new InputValidator().validateGameCommand(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}