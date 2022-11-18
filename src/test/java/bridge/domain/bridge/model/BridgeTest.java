package bridge.domain.bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class BridgeTest {
    @Test
    public void 다리_생성_크기_테스트() {
        int bridgeSize = 6;
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        List<String> bridgeBluePrint = bridgeMaker.makeBridge(bridgeSize);

        Bridge bridge = Bridge.from(bridgeBluePrint);

        Assertions.assertThat(bridge.size()).isEqualTo(bridgeSize);
    }

    @Test
    public void 다리_생성_테스트() {
        List<String> blueprint = Lists.newArrayList("U", "D", "D", "U");

        Bridge bridge = Bridge.from(blueprint);
        Assertions.assertThat(bridge.getBridgeMapComponents())
                .containsExactly(
                        BridgeMapComponent.UP,
                        BridgeMapComponent.DOWN,
                        BridgeMapComponent.DOWN,
                        BridgeMapComponent.UP);
    }

}