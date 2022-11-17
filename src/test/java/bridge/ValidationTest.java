package bridge;

import bridge.utils.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @Test
    void 유효성검사_다리길이_문자() {
        assertThatThrownBy(() -> Validation.validateBridgeSize("a"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @Test
    void 유효성검사_다리길이_최소값미만() {
        assertThatThrownBy(() -> Validation.validateBridgeSize("2"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @Test
    void 유효성검사_다리길이_최대값초과() {
        assertThatThrownBy(() -> Validation.validateBridgeSize("21"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @DisplayName("U와 D 이외의 문자이면 예외가 발생한다.")
    @Test
    void 유효성검사_칸선택() {
        assertThatThrownBy(() -> Validation.validateMoving("R"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @DisplayName("R과 Q 이외의 문자이면 예외가 발생한다.")
    @Test
    void 유효성검사_재시작선택() {
        assertThatThrownBy(() -> Validation.validateRestartInput("U"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }
}
