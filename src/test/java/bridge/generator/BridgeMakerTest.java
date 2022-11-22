package bridge.generator;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("입력한 길이만큼 다리가 생성된다.")
    @ValueSource(strings = {"3", "10", "20"})
    @ParameterizedTest
    void makeBridge(Integer input) {
        List<String> bridge = bridgeMaker.makeBridge(input);
        assertThat(bridge.size()).isEqualTo(input);
    }
}