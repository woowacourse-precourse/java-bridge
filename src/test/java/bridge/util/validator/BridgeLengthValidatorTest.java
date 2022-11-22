package bridge.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

public class BridgeLengthValidatorTest {
    @DisplayName("입력으로 들어온 게 숫자가 아니라면 오류를 낸다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "10.5", "", " ", "ㄱ", "*"})
    void validateWithNotNumeric(String input) {
        assertThatThrownBy(() -> BridgeLengthValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력으로 들어온 게 3 ~ 20사이의 수가 아니라면 오류를 낸다")
    @ParameterizedTest
    @ValueSource(strings = {"-10", "-1", "0", "21", "100"})
    void validateWithInValidNumeric(String input) {
        assertThatThrownBy(() -> BridgeLengthValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력으로 들어온 게 3 ~ 20사이의 수라면 오류 없다")
    @ParameterizedTest
    @ValueSource(strings = {"3", "11", "20"})
    void validateWithValidNumeric(String input) {
        assertThatCode(() -> BridgeLengthValidator.validate(input))
                .doesNotThrowAnyException();
    }
}
