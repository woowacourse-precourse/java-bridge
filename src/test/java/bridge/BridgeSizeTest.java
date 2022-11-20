package bridge;

import bridge.model.BridgeSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeSizeTest {
    @DisplayName("다리의 길이가 3 미만이면 예외가 발생한다.")
    @Test
    void createBridgeSizeByUnderSize() {
        assertThatThrownBy(() -> new BridgeSize(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 20 초과면 예외가 발생한다.")
    @Test
    void createBridgeSizeByOverSize() {
        assertThatThrownBy(() -> new BridgeSize(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이는 3 이상 20 이하의 정수여야 한다.")
    @Test
    void createBridgeSizeInvalidValue() {
        assertThatThrownBy(() -> new BridgeSize(-5))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
