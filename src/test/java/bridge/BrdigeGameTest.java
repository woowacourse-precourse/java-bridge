package bridge;

import bridge.model.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.enums.Constant_BridgeGame.*;
import static org.assertj.core.api.Assertions.*;

class BrdigeGameTest {

    @DisplayName("다리 이동 기능 정상 작동 여부")
    @Test
    void testMovingBridge() {
        BridgeGame bridgeGame = new BridgeGame(3);
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.getProgress().get(DOWN_SIDE_PROGRESS.get()).toString()).isEqualTo("[ ,  ,  ]");
    }
}
