package bridge.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator;

    @ParameterizedTest
    @ValueSource(strings = {"a", "bn", "c", " "})
    void 다리_길이_입력_숫자_아닌_경우_예외(String input) {
        validator = new Validator();

        assertThatThrownBy(() -> validator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "40"})
    void 다리_길이_입력_범위_벗어난_경우_예외(String input) {
        validator = new Validator();

        assertThatThrownBy(() -> validator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}