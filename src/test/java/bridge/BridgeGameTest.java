package bridge;

import bridge.domain.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @DisplayName("입력이 UP, 다리도 UP이라면 맵에 U, O를 담아야 한다")
    @Test
    void moveUOTest() {
        String moving = "U";
        String bridge = "U";
        BridgeGame bridgeGame = new BridgeGame();
        HashMap<String, String> movingbridge = bridgeGame.move(moving, bridge);
        HashMap<String, String> comparebridge = new HashMap<>();
        comparebridge.put("U", "O");
        assertThat(movingbridge).isEqualTo(comparebridge);
    }

    @DisplayName("입력이 DOWN, 다리가 UP이라면 맵에 U, X를 담아야 한다")
    @Test
    void moveUXTest() {
        String moving = "D";
        String bridge = "U";
        BridgeGame bridgeGame = new BridgeGame();
        HashMap<String, String> movingbridge = bridgeGame.move(moving, bridge);
        HashMap<String, String> comparebridge = new HashMap<>();
        comparebridge.put("U", "X");
        assertThat(movingbridge).isEqualTo(comparebridge);
    }
}
