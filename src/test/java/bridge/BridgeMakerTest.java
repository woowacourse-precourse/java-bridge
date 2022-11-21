package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("생성한 다리의 길이는 입력받은 길이와 같다.")
    @Test
    void makeBridge() {
        assertThat(bridgeMaker.makeBridge(10).size())
                .isEqualTo(10);
    }

    @DisplayName("생성한 다리는 \"U\" 또는 \"D\"만 포함하고 있다.")
    @Test
    void bridgeContentsTest() {
        List<String> bridge = bridgeMaker.makeBridge(10);
        assertThat(bridge).containsOnly("U", "D");
    }
}