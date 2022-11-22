package bridge.domain.bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.BridgeDirection;
import bridge.domain.bridge.BridgeMap;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class BridgeMapTest {
    @Test
    public void 다리_지도_생성_크기_테스트() {
        int bridgeSize = 6;
        List<String> bridge = randomBridgeWithSize(bridgeSize);

        BridgeMap bridgeMap = BridgeMap.from(bridge);

        Assertions.assertThat(bridgeMap.size()).isEqualTo(bridgeSize);
    }

    @Test
    public void 다리_지도_생성_테스트() {
        List<String> bridge = Lists.newArrayList("U", "D", "D", "U");

        BridgeMap bridgeMap = BridgeMap.from(bridge);
        Assertions.assertThat(bridgeMap.getBridgeDirections())
                .containsExactly(
                        BridgeDirection.UP,
                        BridgeDirection.DOWN,
                        BridgeDirection.DOWN,
                        BridgeDirection.UP);
    }

    @Test
    public void 다리_지도는_수정_할_수_없다() {
        List<String> bridge = randomBridgeWithSize(6);
        BridgeMap bridgeMap = BridgeMap.from(bridge);
        Assertions.assertThatThrownBy(() ->
                        bridgeMap.getBridgeDirections().add(BridgeDirection.UP))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    private List<String> randomBridgeWithSize(int bridgeSize) {
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

}