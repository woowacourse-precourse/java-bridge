package bridge;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @DisplayName("생성된 다리 길이가 입력값과 동일한지 테스트")
    @Test()
    public void createBridge() {
        BridgeGame bridgeGame = new BridgeGame(5);
        assertThat(bridgeGame.getBridgeSize())
                .isEqualTo(5);
    }
}
