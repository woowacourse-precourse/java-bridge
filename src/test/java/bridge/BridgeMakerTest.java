package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    @DisplayName("input에 맞는길이의 다리 list를 생성한다.")
    void generateBridgeBySize() {
        int bridgeSize = 6;

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        assertThat(bridge).hasSize(bridgeSize);
    }
}