package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameControllerTest {
    private GameController gameController = new GameController();
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(Arrays.asList(new String[]{"U", "U", "D"}));
    }

    @Test
    void userWinTest1() {
        bridgeGame.setUser_bridge(Arrays.asList(new String[]{"U", "D", "U"}));
        assertThat(gameController.userWin(bridgeGame)).isEqualTo(false);
    }

    @Test
    void userWinTest2() {
        bridgeGame.setUser_bridge(Arrays.asList(new String[]{"U", "U", "D"}));
        assertThat(gameController.userWin(bridgeGame)).isEqualTo(true);
    }

    @Test
    void checkRetryTest1() {
        assertThat(gameController.checkRetry(bridgeGame, "R")).isEqualTo(true);
    }

    @Test
    void checkRetryTest2() {
        assertThat(gameController.checkRetry(bridgeGame, "Q")).isEqualTo(false);
    }
}
