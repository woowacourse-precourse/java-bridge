package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameTest {

    @Test
    void moveTest() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> topBridge = new ArrayList<>();
        List<String> bottomBridge = new ArrayList<>();
        bridgeGame.move(topBridge, bottomBridge, "U");

        assertThat(List.of("O")).isEqualTo(topBridge);
        assertThat(List.of(" ")).isEqualTo(bottomBridge);
    }
}
