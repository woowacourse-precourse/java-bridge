package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void 랜덤_다리_길이_사이즈_확인() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int result = 3;

        List<String> randomBridge = bridgeMaker.makeBridge(result);
        int randomBridgeSize = randomBridge.size();

        assertThat(randomBridgeSize).isEqualTo(result);
    }
}