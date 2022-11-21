package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {
    @DisplayName("사이즈를 입력받아 다리를 생성한다.")
    @Test
    void bridgeMakerTest() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = List.of("U", "D", "D");

        assertThat(bridgeMaker.makeBridge(3).size()).isEqualTo(bridge.size());

    }
}
