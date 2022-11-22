package bridge;

import bridge.constant.Constant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @DisplayName("만들어진 다리는 U와 D로 이루어져 있다.")
    @Test
    void makeBridgeTest() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int size = 3;
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.stream()
                .filter(s -> s.equals(Constant.UP) || s.equals(Constant.DOWN))
                .count()).isEqualTo(size);
    }

    @DisplayName("만들어진 다리는 입력한 size와 같은 길이이다.")
    @Test
    void makeBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int size = 3;
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge.size()).isEqualTo(size);
    }
}