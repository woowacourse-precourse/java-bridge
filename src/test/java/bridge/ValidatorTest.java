package bridge;

import static bridge.Validator.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("다리 길이 경계값 예외 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void validateSizeRangeExceptionTest(int size) {
        assertThatThrownBy(() -> validateSizeRange(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 경계값 통과 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {3, 20})
    void validateSizeRangeTest(int size) {
        assertThatCode(() -> validateSizeRange(size)).doesNotThrowAnyException();
    }
}