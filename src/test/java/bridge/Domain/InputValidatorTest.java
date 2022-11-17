package bridge.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @DisplayName("잘못된 위, 아래 입력 예외 throw")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "bb", "d", "u", "", " "})
    void validateSelectionInput(String input) {
        assertThatThrownBy(() -> InputValidator.validateSelectionInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}