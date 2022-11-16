package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @Test
    void 다리_플레이어_일치() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(new Bridge("U", "U"), 0);
        bridgeGame.move(new Bridge("D", "D"), 1);
        bridgeGame.move(new Bridge("D", "D"), 2);
        assertThat(bridgeGame.getMyAnswerBridges()).isEqualTo(List.of("U", "D", "D"));
    }

    @Test
    void 다리_플레이어_불일치() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(new Bridge("U", "U"), 0);
        bridgeGame.move(new Bridge("D", "U"), 1);
        List<String> result = bridgeGame.getMyAnswerBridges();
        assertThat(result.contains("X")).isTrue();
    }
}
