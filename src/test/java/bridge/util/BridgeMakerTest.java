package bridge.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @DisplayName("임의의 다리를 생성한다.")
    @Test
    void makeBridge() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(6);
            assertThat(bridge).isEqualTo(List.of("D", "U", "D", "U", "D", "U"));
        }, 0, 1, 0, 1, 0, 1);
    }
}