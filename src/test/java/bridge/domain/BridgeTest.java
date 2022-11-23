package bridge.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void init() {
        bridge = new Bridge(List.of("U","D","U"));
    }

    @DisplayName("이동할 수 있는 블록")
    @Test
    void canMoveBlock() {
        boolean actual = bridge.canMove(1,"D");
        assertEquals(true, actual);
    }

    @DisplayName("이동할 수 없는 블록")
    @Test
    void cantMoveBlock() {
        boolean actual = bridge.canMove(1,"U");
        assertEquals(false, actual);
    }
}
