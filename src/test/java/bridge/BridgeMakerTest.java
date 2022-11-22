package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    @DisplayName("다리의 생성을 확인한다.")
    @Test
    void bridgeMaker() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);

        assertThat(bridge.size()).isEqualTo(5);
    }
}
