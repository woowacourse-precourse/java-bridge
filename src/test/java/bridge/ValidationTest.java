package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidationTest {
    @ValueSource(strings = {"03", "3.0", "a", "a2", "+3", "-3", "0", "", " ", "\n", "ㄱ"})
    @ParameterizedTest(name = "[{index}] input = {0}")
    void 다리길이_양의_정수_이외의_예외처리_테스트(String input) {
        assertThatThrownBy(() -> Validation.isPositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}