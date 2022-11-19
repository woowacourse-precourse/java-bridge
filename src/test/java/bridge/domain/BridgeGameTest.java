package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    @DisplayName("다리에서 간을 이동한 결과가 잘나오는지 테스트")
    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame();
        assertThat(bridgeGame.move(List.of("U", "D", "D"), 0, "U")).isEqualTo(1);
        assertThat(bridgeGame.move(List.of("U", "D", "D"), 0, "D")).isEqualTo(0);
    }

    @Test
    void retry() {
    }
}