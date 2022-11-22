package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {

    @Test
    void 다리_이동_실패() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U", true, bridge);
        bridgeGame.move("U", false, bridge);
        assertThat(bridge.getUpsideBridge()).containsExactly(" O ", " X ");
        assertThat(bridge.getDownBridge()).containsExactly("   ", "   ");
    }

    @Test
    void 다리_이동_성공() {
        List<String> testMovement = List.of("U", "D", "D");
        Bridge bridge = new Bridge(testMovement);
        BridgeGame bridgeGame = new BridgeGame();
        for (String moving : testMovement) {
            bridgeGame.move(moving, true, bridge);
        }
        assertThat(bridge.getUpsideBridge()).containsExactly(" O ", "   ", "   ");
        assertThat(bridge.getDownBridge()).containsExactly("   ", " O ", " O ");
    }

    @Test
    void 재시작시_다리_이동_초기화() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U", true, bridge);
        bridgeGame.move("U", false, bridge);
        bridgeGame.retry(bridge);
        assertThat(bridge.getDownBridge()).isEmpty();
        assertThat(bridge.getDownBridge()).isEmpty();
    }
}
