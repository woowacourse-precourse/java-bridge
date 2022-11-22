package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;
public class BridgeMakerTest {
    BridgeMaker bridgeMaker;

    BridgeMakerTest() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    void testMakeBridgeTrue() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThat(bridgeMaker.makeBridge(5)).containsExactly("U", "D", "U", "D", "U");
                },
                1, 0, 1, 0, 1
        );
    }
}
