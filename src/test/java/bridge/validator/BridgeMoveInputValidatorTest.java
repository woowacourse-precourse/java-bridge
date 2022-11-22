package bridge.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMoveInputValidatorTest {

    @DisplayName("Validate Bridge Move Input has proper size")
    @ParameterizedTest
    @ValueSource(strings = {"", "UD", "UDD"})
    void sizeCheck(String input) {
        assertThrows(IllegalArgumentException.class, () -> BridgeMoveInputValidator.sizeCheck(input));
    }

    @DisplayName("Validate Bridge Move Input has proper type")
    @ParameterizedTest
    @ValueSource(strings = {"12", "384", "위", "아", "ㅁ"})
    void typeCheck(String input) {
        assertThrows(IllegalArgumentException.class, () -> BridgeMoveInputValidator.typeCheck(input));
    }

}