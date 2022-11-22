package bridge.util.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BlankValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1","a"})
    void 공백_입력_방지_테스트(String input) {
        BlankValidator.isBlank(input, "[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    void 공백_입력_방지_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> BlankValidator.isBlank(input, "[ERROR]"));
    }
}