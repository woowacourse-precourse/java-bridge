package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {

    @DisplayName("길이가 5인 다리 생성")
    @Test
    void makeBridgeByFive() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(5);
        int bridgeLength = 5;

        Assertions.assertThat(bridge.size()).isEqualTo(bridgeLength);
    }
    @DisplayName("길이가 3인 다리 생성")
    @Test
    void makeBridgebyThree() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(3);
        int bridgeLength = 3;

        Assertions.assertThat(bridge.size()).isEqualTo(bridgeLength);
    }

}