package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BridgeTest {

    @Test
    void move() {
        Bridge bridge = new Bridge(List.of("U", "D"));
        String moveControl = "U";

        assertAll(() -> assertTrue(bridge.move(moveControl, 0)),
                () -> assertFalse(bridge.move(moveControl, 1)));
    }
}
