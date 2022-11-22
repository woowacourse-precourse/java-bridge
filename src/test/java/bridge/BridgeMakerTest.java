package bridge;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BridgeMakerTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            assertThat(bridgeMaker.makeBridge(10)).containsExactly("U", "D", "U", "U", "U", "D", "D", "U", "D", "U");
        }, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1);
    }

    @Test
    void 다리_생성_에러() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> bridgeMaker.makeBridge(21));
        String message = exception.getMessage();
        assertThat(message).contains(ERROR_MESSAGE);
    }
}
