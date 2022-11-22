package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private List<String> bridge;
    private BridgeGame bridgeGame;

    public enum GameStatus {
        WIN("WIN"),
        SAFE("SAFE"),
        R("RETRY"),
        U("U"),
        D("D");
        private String status;
        private GameStatus(String status) {
            this.status = status;
        }
    }

    @BeforeEach
    void setUp() {
        bridge = new ArrayList<>(Arrays.asList("U", "D", "U", "U", "D"));
        bridgeGame = new BridgeGame();
    }

    @Test
    void safeMoveTest() {
        String moving = GameStatus.U.status;
        String result = bridgeGame.move(bridge,moving,0);
        assertThat(result).isEqualTo(GameStatus.SAFE.status);
    }

    @Test
    void notSafeMoveTest() {
        String moving = GameStatus.D.status;
        String result = bridgeGame.move(bridge,moving,0);
        assertThat(result).isEqualTo(GameStatus.R.status);
    }

    @Test
    void winTest() {
        String moving = GameStatus.D.status;
        String result = bridgeGame.move(bridge,moving,4);
        assertThat(result).isEqualTo(GameStatus.WIN.status);
    }


    @Test
    void retry() {
        String result = bridgeGame.retry();
        assertThat(result).isEqualTo(GameStatus.R.status);
    }
}
