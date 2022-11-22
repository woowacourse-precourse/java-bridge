package bridge.condition;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class IsNumberInRangeCondTest {

    private static final Condition condition = IsNumberInRangeCond.getInstance();

    @DisplayName("올바른 다리 길이 검증")
    @ValueSource(strings = {"3", "15", "20"})
    @ParameterizedTest
    void 올바른_다리_길이(String input) {
        assertThat(condition.test(input)).isTrue();
    }

    @DisplayName("잘못된 다리 길이 검증")
    @ValueSource(strings = {"1", "21", "a", "1a", "aa", "-1", "aaa"})
    @ParameterizedTest
    void 잘못된_다리_길이(String input) {
        assertThat(condition.test(input)).isFalse();
    }
}