package bridge.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ComparisonTest {

    @Test
    void comparisonSpace() {
        String input = "U";
        assertTrue(Comparison.comparisonSpace(input, new ArrayList<>(List.of("U", "D", "D"))));
        System.out.println(BridgeGame.bridgeResult);
        System.out.println(BridgeGame.moveIndex);
    }
}