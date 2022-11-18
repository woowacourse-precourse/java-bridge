package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommonInputExceptionTest {

    @DisplayName("입력이 없거나 공백이 있다면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} {displayName} input : {0}")
    @ValueSource(strings = {"", " "})
    void inputIsBlank(String input) {
        assertThatThrownBy(() -> CommonInputException.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
