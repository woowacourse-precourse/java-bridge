package bridge.models;

import static org.assertj.core.api.Assertions.*;

import bridge.utils.BridgeNumberGenerator;
import bridge.utils.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void makeBridge_올바른_길이_반환() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThat(bridgeMaker.makeBridge(5).size()).isEqualTo(5);
    }

    @Test
    void makeBridge_올바른_원소_U또는_D만_포함() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThat(bridgeMaker.makeBridge(5))
                .containsOnly("U", "D");
    }
}