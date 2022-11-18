package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.ErrorCode.WRONG_BRIDGE_LENGTH_INPUT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

//    @Test
    @DisplayName("다리 길이 입력이 유효한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"3", "5"})
    void bridgeLengthCorrectValue(String length) {
        // given
        Validator validator = new Validator();

        // then
        validator.bridgeLengthValidate(length);
    }

    @DisplayName("다리 길이 입력이 유효하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1", "21", "a"})
    void bridgeLengthWrongValue(String length) {
        // given
        Validator validator = new Validator();

        // then
        assertThatThrownBy(() -> validator.bridgeLengthValidate(length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_BRIDGE_LENGTH_INPUT);
    }
}
