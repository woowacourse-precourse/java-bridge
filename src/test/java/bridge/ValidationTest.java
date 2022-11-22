package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidationTest {
    @ValueSource(strings = {"03", "3.0", "a", "a2", "+3", "-3", "0", "", " ", "\n", "ㄱ", "1_000_000_000"})
    @ParameterizedTest(name = "[{index}] input = {0}")
    void 다리개수_양의_정수_이외의_예외처리_테스트(String input) {
        assertThatThrownBy(() -> Validation.isPositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 10억 미만의 양의 정수이어야 합니다.");
    }

    @ValueSource(ints = {1,2,21,100,999_999_999})
    @ParameterizedTest(name = "[{index}] input = {0}")
    void 다리길이_범위_테스트(int input) {
        assertThatThrownBy(() -> Validation.isInRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}