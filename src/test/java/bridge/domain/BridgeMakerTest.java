package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    public void 다리_생성(int size){
        List<String> bridge= bridgeMaker.makeBridge(size);

        assertThat(bridge).containsAnyOf("U", "D");
        assertThat(bridge.size()).isEqualTo(size);
    }
}