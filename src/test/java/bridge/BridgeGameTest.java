package bridge;

import bridge.position.Latitude;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {

    private final List<String> bridge = List.of("U", "D", "D");
    private final BridgeGame bridgeGame = new BridgeGame(bridge);

    @Test
    @DisplayName("")
    void moveSafe() {
        Assertions.assertThat(bridgeGame.move(Latitude.UP)).isEqualTo(true);
    }

    @Test
    @DisplayName("")
    void moveDanger() {
        Assertions.assertThat(bridgeGame.move(Latitude.DOWN)).isEqualTo(false);
    }

    @Test
    @DisplayName("")
    void isProcessing() {
        bridgeGame.move(Latitude.UP);
        Assertions.assertThat(bridgeGame.isProcessing()).isEqualTo(true);
    }

    @Test
    @DisplayName("")
    void isProcessingByPlayerDeath() {
        bridgeGame.move(Latitude.DOWN);
        Assertions.assertThat(bridgeGame.isProcessing()).isEqualTo(false);
    }

    @Test
    @DisplayName("")
    void isProcessingByPlayerWin() {
        bridgeGame.move(Latitude.UP);
        bridgeGame.move(Latitude.DOWN);
        bridgeGame.move(Latitude.DOWN);
        Assertions.assertThat(bridgeGame.isProcessing()).isEqualTo(false);
    }
}
