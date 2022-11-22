package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeSizeTest {
    @DisplayName("다리 길이 입력 값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void checkBridgeSizeIsNotNumeric() {
        assertThatThrownBy(() -> new BridgeSize("abcd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력 값이 3이상 20이하가 아니면 예외가 발생한다.")
    @Test
    void checkBridgeSizeInputRange() {
        assertThatThrownBy(() -> new BridgeSize("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
