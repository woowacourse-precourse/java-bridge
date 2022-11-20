package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.GameCommand;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private BridgeGame bridgeGame = new BridgeGame();
    private UserBridge userBridge = new UserBridge();

    @Test
    void 재시작_테스트() {
        BridgeGameManager bridgeGameManager = new BridgeGameManager();
        int count = bridgeGameManager.getCount();
        bridgeGame.retry(bridgeGameManager, userBridge, GameCommand.R.name());

        assertThat(userBridge.getUpBridge().isEmpty()).isTrue();
        assertThat(userBridge.getDownBridge().isEmpty()).isTrue();
        assertThat(bridgeGameManager.getCount()).isEqualTo(count+1);
    }
}
