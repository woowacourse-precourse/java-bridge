package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeMakerTest {
    @Test
    void makeBridgeTest() {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker tester = new BridgeMaker(generator);
        List<String> testBridge = tester.makeBridge(5);
        assertThat(testBridge.size()).isEqualTo(5);
        assertThat(testBridge).containsOnly("U", "D");
    }
}
