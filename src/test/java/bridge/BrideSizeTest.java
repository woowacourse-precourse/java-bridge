package bridge;

import bridge.domain.bridge.BridgeSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BrideSizeTest {
    @DisplayName("다리 길이에 문자가 있으면 예외가 발생한다. (문자열)")
    @Test
    void createBridgeSizeByString() {
        assertThatThrownBy(() -> new BridgeSize("100!"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리 길이에 문자가 있으면 예외가 발생한다. (실수)")
    @Test
    void createBridgeSizeByFloat() {
        assertThatThrownBy(() -> new BridgeSize("23.5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3부터 20 까지의 숫자가 아니면 예외가 발생한다. (OverFlow)")
    @Test
    void createBridgeSizeByOverSize() {
        assertThatThrownBy(() -> new BridgeSize("23"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3부터 20 까지의 숫자가 아니면 예외가 발생한다. (underFlow)")
    @Test
    void createBridgeSizeByUnderSize() {
        assertThatThrownBy(() -> new BridgeSize("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
