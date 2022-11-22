package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class BridgeMakerTest {

    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    @Test
    @DisplayName("랜덤 다리 만들기 테스트")
    void makeBridge() {
        List<String> bridge;
        int size = 10;

        bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
        assertThat(bridge.size()).isEqualTo(size);
    }

}
