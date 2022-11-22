package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @Test
    void 다리건너기_정답_테스트() {
        List<String> footholds = Arrays.asList("U", "U", "D", "D");
        List<String> crossed = Arrays.asList("U", "U", "D", "D");
        Bridge bridge = new Bridge(footholds, crossed);

        Boolean correct = bridgeGame.isCorrect(bridge);

        Assertions.assertThat(correct).isEqualTo(true);
    }

    @Test
    void 다리건너기_오답_테스트() {
        List<String> footholds = Arrays.asList("U", "U", "D", "D");
        List<String> crossed = Arrays.asList("U", "U", "D", "U");
        Bridge bridge = new Bridge(footholds, crossed);

        Boolean correct = bridgeGame.isCorrect(bridge);

        Assertions.assertThat(correct).isEqualTo(false);
    }

}
