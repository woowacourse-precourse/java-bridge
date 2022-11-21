package bridge.utils;

import static bridge.domain.ErrorMessage.BRIDGE_SIZE_INCORRECT_INPUT;
import static bridge.domain.ErrorMessage.BRIDGE_INCORRECT_SIZE;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {
    @Test
    void 다리길이에_숫자_아닌_문자_입력() {
        String input = "4a";
        try {
            Validation.validateBridgeSize(input);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(BRIDGE_SIZE_INCORRECT_INPUT.toString(), e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "21", "30"})
    void 다리길이_3_미만_20_초과_길이_입력(String input) {
        try {
            Validation.validateBridgeSize(input);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(BRIDGE_INCORRECT_SIZE.toString(), e.getMessage());
        }
    }
}