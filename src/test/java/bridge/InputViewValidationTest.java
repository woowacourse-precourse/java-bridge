package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.constant.ErrorConstant.ERROR_BLANK_INPUT;
import static bridge.constant.ErrorConstant.ERROR_NON_INTEGER;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewValidationTest {

    @DisplayName("예외 처리 : 입력값이 숫자가 아닐때 에러 발생 검증")
    @ParameterizedTest
    @ValueSource(strings = {"10h","hello"," "})
    void checkNotValidDigitInputValidation(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.isValidInput(input))
                .withMessageStartingWith(ERROR_NON_INTEGER);
    }

    @DisplayName("예외 처리 : 값을 입력하지 않았을때 에러 발생 검증")
    @Test
    void checkBlankInputValidation() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.isValidInput(""))
                .withMessageStartingWith(ERROR_BLANK_INPUT);
    }
}
