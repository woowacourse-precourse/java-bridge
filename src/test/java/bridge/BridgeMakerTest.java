package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ParameterizedTest(name = "{displayName} {index}")
    @ValueSource(ints = {3, 10, 20})
    @DisplayName("옳바른 다리 길이 테스트")
    void rightBridgeSizeTest(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
    }
}
