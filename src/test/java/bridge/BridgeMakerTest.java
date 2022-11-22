package bridge;

import org.junit.jupiter.api.Test;

import bridge.Constant.Constant;
import bridge.Model.BridgeMaker;
import bridge.Model.BridgeRandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @Test
    void 다리_생성_테스트() {
        int size = 3;
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
        assertThat(bridge.stream().allMatch(e -> e.equals(Constant.Up) || e.equals(Constant.Down))).isTrue();
    }
}
