package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void move() {
        List<String> bridgeMovedHistory = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(new GameStatus(), bridgeMovedHistory);
        List<String> bridgeMoved = bridgeGame.move("U");

        assertThat(bridgeMoved).containsExactly("U", "D", "U", "U");
    }

    @Test
    void retry() {
        List<String> bridgeMovedHistory = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(new GameStatus(), bridgeMovedHistory);
        boolean retryStatus = bridgeGame.retry("R");

        assertThat(retryStatus).isTrue();
    }
}