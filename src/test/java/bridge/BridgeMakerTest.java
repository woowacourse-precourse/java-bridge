package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 12, 20})
    void 다리_생성_테스트(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);

        assertThat(bridges)
                .containsAnyOf("U", "D")
                .hasSize(bridgeSize);

    }


}