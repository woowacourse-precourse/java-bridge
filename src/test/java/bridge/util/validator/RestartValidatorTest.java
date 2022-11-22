package bridge.util.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RestartValidatorTest {
    RestartValidator restartValidator;

    @BeforeEach
    void setUp() {
        restartValidator = new RestartValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void 재시작_테스트(String input) {
        restartValidator.validate(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a", "1"})
    void 재시작_예외_테스트(String input) {
        assertThatThrownBy(() -> restartValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}