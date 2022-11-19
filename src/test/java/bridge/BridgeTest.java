package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.Direction.DOWN;
import static bridge.Direction.UP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeTest {

    @Test
    @DisplayName("유효한 칸인지 확인")
    void isPassable() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        assertTrue(bridge.isPassable(0, "U"));
        assertTrue(bridge.isPassable(1, "D"));
        assertTrue(bridge.isPassable(2, "U"));
    }

}