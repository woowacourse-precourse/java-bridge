package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BridgeTest {

    @Test
    void matchStep() {
        Bridge bridge = new Bridge(List.of("U", "D"));
        String upKey = "U";
        String downKey = "D";

        assertAll(() -> assertTrue(bridge.matchStep(0, upKey)),
                () -> assertFalse(bridge.matchStep(0, downKey)));
    }

}
