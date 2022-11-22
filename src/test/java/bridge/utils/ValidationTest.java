package bridge.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import static bridge.domain.ErrorMessage.BRIDGE_SIZE_INCORRECT_INPUT;
import static bridge.domain.ErrorMessage.BRIDGE_INCORRECT_SIZE;
import static bridge.domain.ErrorMessage.GAME_COMMAND_INCORRECT_INPUT;
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
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> Validation.validateBridgeSize(input));
        assertThat(e.getMessage()).isEqualTo(BRIDGE_INCORRECT_SIZE.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"UP", "DOWN", "M", "u", "d"})
    @DisplayName("이동할 칸에 'U' 또는 'D'가 아닌 값을 입력하면 예외 발생")
    void 이동할_칸_U_또는_D가_아닌_입력(String input) {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> Validation.validateMoving(input));
        assertThat(e.getMessage()).isEqualTo(MOVING_INCORRECT_INPUT.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"RESTART", "QUIT", "U", "r", "q"})
    @DisplayName("게임 재시작/종료 여부에 'R' 또는 'Q'가 아닌 값을 입력하면 예외 발생")
    void 게임_재시작_여부에_R_또는_Q가_아닌_입력(String input) {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> Validation.validateGameCommand(input));
        assertThat(e.getMessage()).isEqualTo(GAME_COMMAND_INCORRECT_INPUT.toString());
    }
}