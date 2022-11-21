package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {
    BridgeNumberGenerator numberGenerator
            = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 1));
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

    @Test
    @DisplayName("다리 생성 테스트")
    void validateBridgeMaker() {
        List<String> bridge = bridgeMaker.makeBridge(4);
        assertThat(bridge).containsExactly("U", "D", "D", "U");
    }
}
