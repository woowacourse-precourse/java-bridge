package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private List<String> bridge;
    private Referee referee;
    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridge = new ArrayList<>(Arrays.asList("U", "D", "D", "D"));
        referee = new Referee(bridge);
        bridgeGame = new BridgeGame(referee, new ArrayList<>(), 1);
    }

    @Test
    void checkMoveUnCorrectly() {
        bridgeGame.move("D");
        assertThat(bridgeGame.isStepSuccess()).isEqualTo(false);
        assertThat(bridgeGame.analyzeResult())
                .isEqualTo(Arrays.asList(Arrays.asList(" "), Arrays.asList("X")));

    }

    @Test
    void checkMoveCorrectly() {
        for(String direction:Arrays.asList("U","D","D")){
            bridgeGame.move(direction);
        }
        assertThat(bridgeGame.isStepSuccess()).isEqualTo(true);
        assertThat(bridgeGame.analyzeResult())
                .isEqualTo(Arrays.asList(Arrays.asList("O"," "," "), Arrays.asList(" ","O","O")));
    }
    @Test
    void checkRetry() {
        bridgeGame.move("D");
        assertThat(bridgeGame.isStepSuccess()).isEqualTo(false);
        assertThat(bridgeGame.analyzeResult())
                .isEqualTo(Arrays.asList(Arrays.asList(" "), Arrays.asList("X")));
        bridgeGame.retry();
        assertThat(bridgeGame.getAttempt())
                .isEqualTo(2);

    }

}