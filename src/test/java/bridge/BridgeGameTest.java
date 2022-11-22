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
}
