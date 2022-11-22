package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;


class BridgeMakerTest {

    @DisplayName("다리를 정상적으로 잘 만드는가")
    @Test
    void makeBridgeTest() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            assertThat(bridgeMaker.makeBridge(5)).containsExactly("U", "D", "U", "U","D");
        }, 1, 0, 1,1,0);
    }
}