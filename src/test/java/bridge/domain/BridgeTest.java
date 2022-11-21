package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("지정한 다리 길이 값으로 만들어지는지 확인")
    @Test
    void 다리_길이_테스트() {
        int size = 5;
        List<String> madeBridge = bridgeMaker.makeBridge(size);
        Bridge bridge = new Bridge(madeBridge);

        assertThat(bridge.getBridgeLength()).isEqualTo(size);
    }

}