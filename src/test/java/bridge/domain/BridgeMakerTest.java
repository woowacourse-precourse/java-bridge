package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 6, 7, 10, 13, 18})
    @DisplayName("size가 주어지면 size 길이의 다리가 만들어진다. ")
    void createBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge.size()).isEqualTo(size);
    }
}