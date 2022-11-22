package bridge.validator;

import bridge.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NumberValidatorTest {
    private final static String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3~20 중의 숫자여야 합니다.";

    @DisplayName("다리 길이가 3~20중의 숫자가 아닐 시 예외가 발생한다.")
    @Nested
    class BridgeSizeTest {
        @CsvSource({"3", "4", "13", "19", "20"})
        @ParameterizedTest
        void 값이_올바른_경우(String input) {
            NumberValidator.validateNonNumeric(input);
            NumberValidator.validateRange(input);
        }

        @CsvSource({"!", "ㄱ", "p", "~", "ㅕ7", "4a"})
        @ParameterizedTest
        void 숫자가_아닌_경우(String input) {
            assertThatThrownBy(() -> NumberValidator.validateNonNumeric(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NON_NUMERIC_ERROR_MESSAGE);
        }

        @CsvSource({"-1", "1", "0", "55", "985"})
        @ParameterizedTest
        void 숫자의_범위가_아닌_경우(String input) {
            assertThatThrownBy(() -> NumberValidator.validateRange(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(RANGE_ERROR_MESSAGE);
        }
    }
}
