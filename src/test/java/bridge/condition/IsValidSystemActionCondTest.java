package bridge.condition;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class IsValidSystemActionCondTest {

    private static final Condition condition = IsValidSystemActionCond.getInstance();

    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void 유효한_입력값_검증(String input) {
        Assertions.assertThat(condition.test(input)).isTrue();
    }

    @ValueSource(strings = {"r", "q", "", "a", "RR"})
    @ParameterizedTest
    void 유효하지_않은_입력값_검증(String input) {
        Assertions.assertThat(condition.test(input)).isFalse();
    }
}