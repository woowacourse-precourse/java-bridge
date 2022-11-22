package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker;

    @BeforeEach
    void initBridgeMaker(){
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    @Test
    @DisplayName("랜덤으로 구성된 다리가 잘 생성되는지 확인한다.")
    void makeBridge() {
        final int BRIDGE_SIZE = 5;
        List<String> bridge = bridgeMaker.makeBridge(BRIDGE_SIZE);
        
        Assertions.assertThat(bridge.size()).isEqualTo(BRIDGE_SIZE);
    }
}