package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    public void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리 생성 테스트")
    @Test
    public void generateBridgeRandomly() {
        assertRandomNumberInRangeTest(() -> {
            List<String> bridge = bridgeMaker.makeBridge(6);
            assertThat(bridge).containsExactly("U", "D", "U", "D", "U", "D");
        }, 1, 0, 1, 0, 1, 0);
    }
}