package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {
    @ValueSource(strings = {"a", "10a", " ", "@@"})
    @ParameterizedTest
    void 다리_길이_숫자_아닌_경우(String size) {
        assertThatThrownBy(() -> InputValidation.convertToInt(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(ints = {1, 2, 21, 300})
    @ParameterizedTest
    void 다리_길이_범위밖일_경우(int size) {
        assertThatThrownBy(() -> InputValidation.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}