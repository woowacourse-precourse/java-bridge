package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeSizeTest {
    @DisplayName("다리 크기가 1일 때 예외 테스트")
    @Test
    public void bridgeSizeOneExceptionTest() {
        assertThatThrownBy(() -> new BridgeSize("1")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 문자열이 숫자가 아닌 경우 예외 테스트")
    @Test
    public void bridgeSizeNotNumberExceptionTest() {
        assertThatThrownBy(() -> new BridgeSize("a33"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
