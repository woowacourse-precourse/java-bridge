package bridge;

import bridge.service.BridgeGame;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    List<String> bridge;

    BridgeGame bridgeGame;

    @BeforeEach
    void setBridgeGame() {
        bridgeGame = new BridgeGame();
        bridge = bridgeGame.makeBridge(3);
    }

    @Nested
    class makeBridgeTest {
        @DisplayName("다리길이 입력시 생성된 다리 사이즈 확인")
        @Test
        void bridgeSizeTest() {
            int checkSize = 3;
            Assertions.assertThat(bridge.size()).isEqualTo(checkSize);
        }
    }
}
