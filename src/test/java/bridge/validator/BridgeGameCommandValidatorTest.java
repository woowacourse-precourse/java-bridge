package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameCommandValidatorTest {

    @DisplayName("커맨드 문자열이 'U', 'D'가 아닐 때 Exception 을 던지는지 확인")
    @ParameterizedTest(name = "[{index}]번째 테스트 : {0}")
    @ValueSource(strings = {"A", "B", "C", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z"})
    void movingCommandWithInvalidCharacter(final String command) {
        assertThatThrownBy(() -> BridgeGameCommandValidator.checkMovingCommandCharacter(command))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("커맨드 문자열이 'R', 'Q'가 아닐 때 Exception 을 던지는지 확인")
    @ParameterizedTest(name = "[{index}]번째 테스트 : {0}")
    @ValueSource(strings = {"A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "S", "T", "U", "V", "W", "X", "Y", "Z"})
    void retryCommandWithInvalidCharacter(final String command) {
        assertThatThrownBy(() -> BridgeGameCommandValidator.checkRetryGameCommandCharacter(command))
                .isInstanceOf(IllegalStateException.class);
    }
}