package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("사이즈에 맞게 생성되는지 확인")
    @Test
    void bridgeSize() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge.size()).isEqualTo(5);
    }

    @DisplayName("U와 D로 이루어지는지 확인")
    @Test
    void bridgeComponent() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(10);
        assertThat(bridge.stream()
                .filter(s -> s.equals("U") || s.equals("D")).count())
                .isEqualTo(bridge.size());
    }
}
