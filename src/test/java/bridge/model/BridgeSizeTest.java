package bridge.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeSizeTest {

    private static final int BRIDGE_SIZE = 5;

    @DisplayName("다리 사이즈는 3이상 20이하로 생성해야 한다.")
    @Test
    void createByCorrectSize() {
        assertThat(new BridgeSize(BRIDGE_SIZE).intValue()).isEqualTo(BRIDGE_SIZE);
    }

    @DisplayName("다리 사이즈가 3미만 20초과면 예외가 발생한다.")
    @Test
    void createByStrangeSize() {
        assertThatThrownBy(() -> new BridgeSize(1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BridgeSize(100)).isInstanceOf(IllegalArgumentException.class);
    }
}
