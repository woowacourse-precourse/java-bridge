package bridge.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

public class GameCommandValidatorTest {
    @DisplayName("입력으로 들어온 게 Q나 R이 아니라면 오류를 낸다")
    @ParameterizedTest
    @ValueSource(strings = {"X", "q", "r", " ", "", "1", "QUIT", "RETRY"})
    void validateWithInValidCommand(String input) {
        assertThatThrownBy(() -> GameCommandValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력으로 들어온 게 Q나 R이라면 오류 없다")
    @ParameterizedTest
    @ValueSource(strings = {"Q", "R"})
    void validateWithValidCommand(String input) {
        assertThatCode(() -> GameCommandValidator.validate(input))
                .doesNotThrowAnyException();
    }
}
