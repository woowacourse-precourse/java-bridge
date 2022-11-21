package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeGameTest {

    List<String> blocks;
    Bridge bridge;
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        blocks = List.of("U", "D", "U");
        bridge = new Bridge(blocks);
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("칸 움직이기 테스트")
    @Test
    void successMovingTest() {
        int position = bridgeGame.move();
        Assertions.assertThat(position).isEqualTo(1);
    }

    @DisplayName("재시도 테스트")
    void retryTest() {
        bridgeGame.move();
        bridgeGame.retry();

        int attempts = bridgeGame.getAttempts();
        Assertions.assertThat(attempts).isEqualTo(2);
    }

}
