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
}
