package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static bridge.message.ErrorMessage.INCORRECT_BRIDGE_DIRECTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeTest {

    @Test
    @DisplayName("경로에 유효한 Direction이 아닌 경우 예외 처리")
    void validateDirection() {
        assertThatThrownBy(() -> new Bridge(List.of("a", "D", "U")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INCORRECT_BRIDGE_DIRECTION);
    }

    @Test
    @DisplayName("유효한 칸인지 확인")
    void isPassable() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        assertTrue(bridge.isPassable(0, "U"));
        assertTrue(bridge.isPassable(1, "D"));
        assertTrue(bridge.isPassable(2, "U"));
    }

}