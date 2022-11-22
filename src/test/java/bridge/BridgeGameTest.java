package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @DisplayName("재시작 입력 테스트")
    @Test
    void 재시작_테스트() {
        BridgeGame bridgeGame = new BridgeGame(5);
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }
}
