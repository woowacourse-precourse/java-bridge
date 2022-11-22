package bridge.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeValidatorTest {

    @DisplayName("입력받은 다리길이가 문자를 포함하면 예외를 발생시킨다.")
    @ValueSource(strings = {"a3", "2,3", "2칸"})
    @ParameterizedTest
    void createSizeByNotInteger(String input) {
        assertThatThrownBy(() -> new BridgeValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 다리길이가 3~20사이 숫자가 아니면 예외를 발생시킨다.")
    @ValueSource(strings = {"-2", "3", "20", "100"})
    @ParameterizedTest
    void createSizeByNotRange(String input) {
        assertThatThrownBy(() -> new BridgeValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

