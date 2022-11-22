package bridge.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
    @DisplayName("숫자 문자열일 때 true 값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "111"})
    void testNumericString(String target) {
        assertThat(Validator.isNumericString(target))
                .isTrue();
    }

    @DisplayName("숫자 문자열 아닐 때 false 값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "-1", " 1"})
    void testNotNumericString(String target) {
        assertThat(Validator.isNumericString(target))
                .isFalse();
    }

    @DisplayName("문자열로된 범위 안에 값이 존재할 때 true 값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    void testInRangeOfString(String target) {
        String[] range = {"a", "b", "c"};
        assertThat(Validator.isInRangeOfString(target, range))
                .isTrue();
    }

    @DisplayName("문자열로된 범위 안에 값이 존재하지 않을 때 false 값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"e", "f", "g"})
    void testNotInRangeOfString(String target) {
        String[] range = {"a", "b", "c"};
        assertThat(Validator.isInRangeOfString(target, range))
                .isFalse();
    }

    @DisplayName("숫자로된 범위 안에 값이 존재할 때 true 값을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 9, 20})
    void testInRangeOfNumber(int target) {
        int start = 3;
        int end = 20;
        assertThat(Validator.isInRangeOfNumber(target, start, end))
                .isTrue();
    }

    @DisplayName("숫자로된 범위 안에 값이 존재하지 않을 때 false 값을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void testNotInRangeOfNumber(int target) {
        int start = 3;
        int end = 20;
        assertThat(Validator.isInRangeOfNumber(target, start, end))
                .isFalse();
    }
}
