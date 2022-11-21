package bridge.utils;

import static bridge.domain.ErrorMessage.BRIDGE_SIZE_INCORRECT_INPUT;
import static bridge.domain.ErrorMessage.BRIDGE_INCORRECT_SIZE;
import static bridge.domain.ErrorMessage.MOVING_INCORRECT_INPUT;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {
    @Test
    @DisplayName("다리 길이에 숫자가 아닌 문자 입력하면 예외 발생")
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
    @DisplayName("다리 길이에 3 미만, 20 초과의 값을 입력하면 예외 발생")
    void 다리길이_3_미만_20_초과_길이_입력(String input) {
        try {
            Validation.validateBridgeSize(input);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(BRIDGE_INCORRECT_SIZE.toString(), e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"UP", "DOWN", "M", "u", "d"})
    @DisplayName("이동할 칸에 'U' 또는 'D'가 아닌 값을 입력하면 예외 발생")
    void 이동할_칸_U_또는_D가_아닌_입력(String input) {
        try {
            Validation.validateMoving(input);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(MOVING_INCORRECT_INPUT.toString(), e.getMessage());
        }
    }
}