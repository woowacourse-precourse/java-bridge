package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    List<String> bridge;

    @BeforeEach
    void init() {
        bridge = bridgeMaker.makeBridge(3);
    }

    @DisplayName("다리 길이가 입력받은 숫자와 동일해야 한다.")
    @Test
    void sameBridgeLengthWithSize() {
        assertThat(bridge.size()).isEqualTo(3);
    }
}