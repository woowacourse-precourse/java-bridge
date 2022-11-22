package bridge.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.input.InputMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
    private static final Validation validation = new Validation();

    @DisplayName("아무 값도 입력하지 않았을 경우 예외 발생")
    @Test
    void 모든_입력_값_유효성_검증1() {
        for (InputMessage inputMessage : InputMessage.values()) {
            assertThatThrownBy(() -> validation.validate("", inputMessage))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("값이 입력되지 않았습니다.");
        }
    }

    @DisplayName("공백이 포함되어 있는 경우 예외 발생")
    @Test
    void 모든_입력_값_유효성_검증2() {
        for (InputMessage inputMessage : InputMessage.values()) {
            assertThatThrownBy(() -> validation.validate("A B", inputMessage))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력 값에 공백이 포함되지 않아야 합니다.");
        }
    }

    @DisplayName("자연수가 아닌 값을 입력하였을 경우 예외 발생")
    @Test
    void 다리_길이_유효성_검증1() {
        assertThatThrownBy(() -> validation.validate("a", InputMessage.INPUT_BRIDGE_SIZE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리의 길이의 입력은 자연수가 되어야 합니다.");
    }

    @DisplayName("3 미만 20 초과 값을 입력하였을 경우 예외 발생")
    @Test
    void 다리_길이_유효성_검증2() {
        assertThatThrownBy(() -> validation.validate("21", InputMessage.INPUT_BRIDGE_SIZE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리의 길이는 3 이상 20 이하여야 합니다.");
    }

    @DisplayName("'U' 또는 'D'가 아닌 값을 입력하였을 경우 예외 발생")
    @Test
    void 이동할_칸의_유효성_검증() {
        assertThatThrownBy(() -> validation.validate("P", InputMessage.INPUT_BRIDGE_MOVE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동할 칸의 입력은 'U' 또는 'D'가 되어야 합니다.");
    }

    @DisplayName("'R' 또는 'Q'가 아닌 값을 입력하였을 경우 예외 발생")
    @Test
    void 재시작_종료_값의_유효성_검증() {
        assertThatThrownBy(() -> validation.validate("=", InputMessage.INPUT_RESTART_CODE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("재시도 여부의 입력은 'R' 또는 'Q'가 되어야 합니다.");
    }
}
