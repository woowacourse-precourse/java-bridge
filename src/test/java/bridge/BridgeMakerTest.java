package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("입력한 길이와 다리 길이가 일치한다")
    @ValueSource(ints = 10)
    @ParameterizedTest
    void test1(int anyValue) {
        List<String> bridge = bridgeMaker.makeBridge(anyValue);
        assertThat(bridge.size()).isEqualTo(anyValue);
    }
}