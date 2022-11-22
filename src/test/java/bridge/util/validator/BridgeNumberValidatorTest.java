package bridge.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

public class BridgeNumberValidatorTest {
    @DisplayName("다리 번호가 0이나 1이 아니라면 오류가 난다")
    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 2, 10})
    void validateWithInValidNumber(int number) {
        assertThatThrownBy(() -> BridgeNumberValidator.validate(number))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("다리 번호가 0이나 1이라면 오류 없다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void validateWithValidNumber(int number) {
        assertThatCode(() -> BridgeNumberValidator.validate(number))
                .doesNotThrowAnyException();
    }
}
