package bridge;

import static org.junit.jupiter.api.Assertions.*;

import bridge.model.PlayerSteps;
import bridge.model.bridge.Bridge;
import bridge.model.bridge.Node;
import java.util.List;
import org.junit.jupiter.api.Test;

class MapMakerTest {
    Bridge bridge;
    PlayerSteps steps;

    @Test
    public void make() {
        List<String> nodePositions = List.of("U", "D", "U", "U");
        bridge = Bridge.of(nodePositions);
        steps = new PlayerSteps(4);
        for (int i = 0; i < 3; i++) {
            steps.add(Node.of(nodePositions.get(i)));
        }

        steps.add(Node.of(nodePositions.get(3)));
        String result = MapMaker.make(bridge, steps);
        assertEquals(result, "[ O |   | O | O ]\n[   | O |   |   ]");
    }
}