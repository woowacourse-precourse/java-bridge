package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @Test
    void 다리_플레이어_일치() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(new Bridge("U", "U"));
        bridgeGame.move(new Bridge("D", "D"));
        bridgeGame.move(new Bridge("D", "D"));
        assertThat(bridgeGame.getMyAnswerBridges()).isEqualTo(List.of("U", "D", "D"));
    }

    @Test
    void 다리_플레이어_불일치() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(new Bridge("U", "U"));
        bridgeGame.move(new Bridge("D", "U"));
        List<String> result = bridgeGame.getMyAnswerBridges();
        assertThat(result.contains("X")).isTrue();
    }

    @Test
    void retry_횟수() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(new Bridge("U", "U"));
        bridgeGame.retry();
        int count = bridgeGame.getAttemptCount();
        assertThat(count).isEqualTo(2);
    }
}
