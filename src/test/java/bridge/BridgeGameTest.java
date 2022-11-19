package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private List<String> blocks;
    private Bridge bridge;
    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        blocks = new ArrayList<>(Arrays.asList("U", "D", "D", "D"));
        bridge = new Bridge(blocks);
        bridgeGame = new BridgeGame(bridge, new ArrayList<>(), 1);
    }

    @Test
    void checkMoveUnCorrectly() {
        bridgeGame.move("D");
        assertThat(bridgeGame.isStepSuccess()).isEqualTo(false);
        assertThat(bridgeGame.analyzeResult())
                .isEqualTo(Arrays.asList(List.of(" "), List.of("X")));

    }

    @Test
    void checkMoveCorrectly() {
        for (String direction : Arrays.asList("U", "D", "D")) {
            bridgeGame.move(direction);
        }
        assertThat(bridgeGame.isStepSuccess()).isEqualTo(true);
        assertThat(bridgeGame.analyzeResult())
                .isEqualTo(Arrays.asList(Arrays.asList("O", " ", " "), Arrays.asList(" ", "O", "O")));
    }

    @Test
    void checkRetry() {
        bridgeGame.move("D");
        assertThat(bridgeGame.isStepSuccess()).isEqualTo(false);
        assertThat(bridgeGame.analyzeResult())
                .isEqualTo(Arrays.asList(List.of(" "), List.of("X")));
        bridgeGame.retry();
        assertThat(bridgeGame.getAttempt())
                .isEqualTo(2);

    }

}