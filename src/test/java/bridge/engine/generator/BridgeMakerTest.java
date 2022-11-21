package bridge.engine.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("입력한 size에 맞게 U와 D로 표현되는 다리가 생성되어야 한다.")
    @Test
    public void createBridge() {
        int BRIDGE_SIZE = 5;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(BRIDGE_SIZE);
        assertThat(bridge.size()).isEqualTo(BRIDGE_SIZE);
        for (String location : bridge) {
            assertThat(location).containsAnyOf("U", "D");
        }
    }
}