package bridge;

import bridge.bridge.BridgeSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BridgeSizeTest {
    @DisplayName("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
    @Test
    void 다리_길이_3보다_작은_경우_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new BridgeSize("1"));
    }

    @Test
    void 다리_길이_20보다_큰_경우_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new BridgeSize("25"));
    }
}
