package bridge.domain.bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class BridgeMapTest {
    @Test
    public void 다리_생성_크기_테스트() {
        int bridgeSize = 6;
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        BridgeMap bridgeMap = BridgeMap.from(bridge);

        Assertions.assertThat(bridgeMap.size()).isEqualTo(bridgeSize);
    }

    @Test
    public void 다리_생성_테스트() {
        List<String> bridge = Lists.newArrayList("U", "D", "D", "U");

        BridgeMap bridgeMap = BridgeMap.from(bridge);
        Assertions.assertThat(bridgeMap.getBridgeDirections())
                .containsExactly(
                        BridgeDirection.UP,
                        BridgeDirection.DOWN,
                        BridgeDirection.DOWN,
                        BridgeDirection.UP);
    }

}