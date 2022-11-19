package bridge.status;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RetryTest {


    @ParameterizedTest
    @ValueSource(strings = {"u", "   ", " U", "d", "A", "B", "S", "s", "b", "a", "r", "q", "  R", "Q   "})
    void 재시작_입력이_R_또는_Q_가_아니라면_false_리턴(String direction) {
        boolean result = Retry.contains(direction);

        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void 재시작_입력이_R_또는_Q_라면_true_리턴(String direction) {
        boolean result = Retry.contains(direction);

        assertThat(result).isTrue();

    }
}