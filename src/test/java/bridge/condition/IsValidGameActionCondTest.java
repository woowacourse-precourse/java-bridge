package bridge.condition;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class IsValidGameActionCondTest {

    private static final Condition condition = IsValidGameActionCond.getInstance();

    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 유효한_행동_입력(String input) {
        assertThat(condition.test(input)).isTrue();
    }

    @ValueSource(strings = {"u", "d", "a", "", "UU"})
    @ParameterizedTest
    void 유효하지_않은_행동_입력(String input) {
        assertThat(condition.test(input)).isFalse();
    }

}