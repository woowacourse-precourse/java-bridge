package bridge.util.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import bridge.util.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeValidatorTest {

    private BridgeSizeValidator validator;

    @BeforeEach
    void setUp() {
        validator = new BridgeSizeValidator();
    }

    @Nested
    class invalidInput {

        @DisplayName("자연수가 아닌 입력")
        @ParameterizedTest
        @ValueSource(strings = {"aaa", "문자", "아아아아", "아 아 아 ㅇ ㅏ", "-1", "-299"})
        void 자연수가_아닌_입력(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }

        @DisplayName("int 범위를 초과한 입력")
        @ParameterizedTest
        @ValueSource(strings = {"1111111111111111111111111", "2183128312887721847281389"})
        void int_입력_범위_초과(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.OUT_OF_INT_RANGE.getMessage());
        }

        @DisplayName("3 이상 20 이하의 값이 아니면 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"0", "1", "2", "21"})
        void 다리_길이_범위를_초과(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NOT_IN_RANGE.getMessage());
        }
    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"3", "4", "19", "20"})
        void 정상_입력(String input) {
            assertThatCode(() -> validator.validate(input))
                    .doesNotThrowAnyException();
        }
    }

}