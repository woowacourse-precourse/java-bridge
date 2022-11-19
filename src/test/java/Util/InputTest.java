package Util;

import bridge.Util.COMMAND_CONSTANTS;
import bridge.Util.InputValidator;
import bridge.Util.STATE_CONSTANTS;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputTest {

    @DisplayName("다리 생성 input의 타입 오류")
    @Test
    void 다리_생성_타입_예외() {
        assertThatThrownBy(() -> InputValidator.validateBridgeInput("jp"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 생성 input의 크기 오류")
    @Test
    void 다리_생성_크기_예외() {
        assertThatThrownBy(() -> InputValidator.validateBridgeInput("25"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 커맨드 입력 체크")
    @Test
    void 움직임_입력_예외() {
        assertThatThrownBy(() -> InputValidator.validateCommand("P", STATE_CONSTANTS.MOVE_STATE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도 커맨드 입력 체크")
    @Test
    void 재시도_입력_예외() {
        assertThatThrownBy(() -> InputValidator.validateCommand("P", STATE_CONSTANTS.RETRY_STATE))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
