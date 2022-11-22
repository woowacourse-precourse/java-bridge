package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @DisplayName("다리 만들기")
    @ValueSource(strings = {"3", "5"})
    @ParameterizedTest
    void makeBridge(Integer input) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(input);

        assertThat(bridge.size()).isEqualTo(input);
        assertThat(bridge).containsAnyOf("D", "U");
    }

}