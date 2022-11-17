package bridge;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    @Test
    void makeBridge_테스트() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            assertThat(bridgeMaker.makeBridge(10)).containsExactly("U", "D", "U", "U","U","D","D","U","D","U");
        }, 1, 0, 1,1,1,0,0,1,0,1);
    }
}
