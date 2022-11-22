package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constants.ValidatorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RetryInputValidatorTest {
    @DisplayName("입력이 Q나 R이 아니라면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"r", " ", "ㅁ", "1",})
    void createNotUorD(String input) {
        assertThatThrownBy(() -> RetryInputValidator.validateRetryInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorMessage.RETRY_INPUT_IS_R_OR_Q.toString());
    }

    @DisplayName("2,100,000,000번 이하의 시도라면 예외가 발생하지 않는다.")
    @Test
    void asd() {
        assertThatCode(() -> TryCountValidator.validateTryCount(2000))
                .doesNotThrowAnyException();
    }
}