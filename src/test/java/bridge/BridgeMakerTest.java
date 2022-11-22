package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {

    @DisplayName("BridgeMaker 기능 테스트")
    @Test
    void bridgeMakerTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge.size()).isEqualTo(3);
        for (int i = 0; i < bridge.size(); i++) {
            assertThat(bridge.get(i)).isIn("D", "U");
        }
    }
}
