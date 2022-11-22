package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeSizeTest {
    @DisplayName("다리 사이즈가 3 미만이면 예외가 발생한다.")
    @Test
    void createBridgeSizeByUnderSize() {
        assertThatThrownBy(() -> new BridgeSize(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 사이즈가 20 이상이면 예외가 발생한다.")
    @Test
    void createBridgeSizeByOverSize() {
        assertThatThrownBy(() -> new BridgeSize(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
