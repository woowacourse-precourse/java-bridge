package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    static final BridgeGame bridgeGame = new BridgeGame();
    @DisplayName("다리에서 칸을 이동한 결과가 잘나오는지 테스트")
    @Test
    void move() {
        assertThat(bridgeGame.move(List.of("U", "D", "D"), 0, "U")).isEqualTo(1);
        assertThat(bridgeGame.move(List.of("U", "D", "D"), 0, "D")).isEqualTo(0);
    }

    @DisplayName("플레이어가 재시작할경우 플레이어의 결과가 리셋되는지 테스트")
    @Test
    void retry() {
        assertThat(bridgeGame.retry()).isEqualTo(List.of());
    }
}