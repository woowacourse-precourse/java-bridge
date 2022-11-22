package bridge.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeInputValidatorTest {

    private static void execute() {
        BridgeSizeInputValidator.typeCheck("k");
    }

    @DisplayName("Validate Bridge Size Input has proper type")
    @Test
    void typeCheck() {
        assertThrows(IllegalArgumentException.class, BridgeSizeInputValidatorTest::execute);
    }

    @DisplayName("Validate Bridge Size Input has proper range")
    @ParameterizedTest
    @ValueSource(strings = {"2", "31"})
    void rangeCheck(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            BridgeSizeInputValidator.rangeCheck(input);
        });
    }
}