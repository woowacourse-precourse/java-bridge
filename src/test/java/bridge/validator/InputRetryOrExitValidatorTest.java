package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputRetryOrExitValidatorTest {

    @DisplayName("사용자가 게임 재시작/종료 여부를 입력할 때 R와 Q 이외의 문자열을 입력할 경우 예외가 발생한다.")
    @ValueSource(strings = {"A", "B", "1", " ", "RQ", "QQQ"})
    @ParameterizedTest
    void validateInvalidRetryOrExitCommand(String input) {
        assertThatThrownBy(() -> InputRetryOrExitValidator.validateRetryOrExitCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}