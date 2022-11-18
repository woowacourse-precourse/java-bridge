package bridge.bridge;

import bridge.utill.TestBridgeGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeTest {
    TestBridgeGenerator testBridgeGenerator = new TestBridgeGenerator();

    @Test
    public void makeBridgeTest() {
        List<String> bridge = testBridgeGenerator.generate(List.of(1, 0, 1, 0, 1));
        assertThat(bridge).isEqualTo(new ArrayList<>(List.of("U", "D", "U", "D", "U")));
    }
}
