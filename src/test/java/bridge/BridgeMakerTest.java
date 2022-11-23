package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeMakerTest {
    @Test
    void 다리_생성_테스트() {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        assertRandomNumberInRangeTest(() -> {
            List<String> bridge = bridgeMaker.makeBridge(3);

            assertThat(bridge).isEqualTo(List.of("U", "U", "U"));
        }, 1, 1, 1);

        assertRandomNumberInRangeTest(() -> {
            List<String> bridge = bridgeMaker.makeBridge(5);

            assertThat(bridge).isEqualTo(List.of("D", "U", "D", "U", "D"));
        }, 0, 1, 0, 1, 0);
    }
}
