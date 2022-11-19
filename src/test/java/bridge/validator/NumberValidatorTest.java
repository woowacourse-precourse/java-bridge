package bridge.validator;

import bridge.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NumberValidatorTest {
    private final static String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3~20 중의 숫자여야 합니다.";

    @DisplayName("다리 길이가 숫자가 아닐 시 예외가 발생한다.")
    @Test
    void numberValidateError() {
        assertThatThrownBy(() -> NumberValidator.validateNonNumeric("r"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_NUMERIC_ERROR_MESSAGE);
        }

    @DisplayName("다리 길이에 3~20이 아닌 숫자를 입력 시 예외가 발생한다.")
    @Test
    void rangeValidateError() {
        assertThatThrownBy(() -> NumberValidator.validateRange("54"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RANGE_ERROR_MESSAGE);
    }
    }