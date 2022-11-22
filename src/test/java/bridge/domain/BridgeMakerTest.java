package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    @Test
    void 입력받는_다리의_길이만큼_다리_제작_테스트() {
        int bridgeSize = 10;
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        assertThat(bridge.size()).isEqualTo(bridgeSize);
    }
}