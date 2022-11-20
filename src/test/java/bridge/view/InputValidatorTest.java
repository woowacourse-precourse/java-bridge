package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        this.inputValidator = new InputValidator();
    }

    @DisplayName("다리 길이 입력 테스트")
    @Nested
    class ValidateBridgeSize {
        @ParameterizedTest(name = "3 이상 20 이하가 아니면 예외 처리한다")
        @ValueSource(ints = {1, 2, 21, 22})
        void inputBridgeLengthOutOfRange(int size) {
            assertThatThrownBy(() -> inputValidator.validateBridgeSizeRange(size))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "3 이상 20 이하의 숫자를 입력할 수 있다.")
        @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
        void inputBridgeLength(int size) {
            assertDoesNotThrow(() -> inputValidator.validateBridgeSizeRange(size));
        }

        @ParameterizedTest(name = "숫자가 아닌 문자면 예외 처리한다.")
        @ValueSource(strings = {" ", "abc", ",./", "가나다", "@#%^&"})
        void inputNumberNotDigit(String text) {
            assertThatThrownBy(() -> inputValidator.inputNumber(text))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "숫자가 공백 또는 Null 이면 예외 처리한다.")
        @NullAndEmptySource
        void inputNumberNull(String text) {
            assertThatThrownBy(() -> inputValidator.inputNumber(text))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "숫자를 입력한다.")
        @ValueSource(strings = {"3", "4", "19", "20"})
        void inputNumber(String text) {
            assertThat(inputValidator.inputNumber(text)).isEqualTo(Integer.parseInt(text));
        }
    }
}
