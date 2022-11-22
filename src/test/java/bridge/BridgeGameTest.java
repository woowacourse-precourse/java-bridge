package bridge;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @Test
    void successAllTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D"));
        BridgeMap bridgeMap = new BridgeMap(bridge,
                List.of(Direction.UP, Direction.DOWN, Direction.UP, Direction.DOWN));
        String answer = "[ O |   | O |   ]\n"
                + "[   | O |   | O ]\n";
        Assertions.assertEquals(bridgeMap.toString(), answer);
    }

    @Test
    void failTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D"));
        BridgeMap bridgeMap = new BridgeMap(bridge,
                List.of(Direction.UP, Direction.DOWN, Direction.DOWN));
        String answer = "[ O |   |   ]\n"
                + "[   | O | X ]\n";
        Assertions.assertEquals(bridgeMap.toString(), answer);
    }


}
