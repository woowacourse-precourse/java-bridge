package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private Bridge upDownUpBridge;

    @BeforeEach
    void setUp() {
        upDownUpBridge = new Bridge(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP));
    }

    @DisplayName("플레이어 이동 테스트")
    @Nested
    class Move {
        @DisplayName("위로 이동한다")
        @Test
        void moveUp() {
            BridgeGame bridgeGame = new BridgeGame(upDownUpBridge);
            bridgeGame.move(BridgeShape.UP);
            BridgeGameResult result = bridgeGame.result();

            assertThat(result).isEqualTo(new BridgeGameResult(upDownUpBridge, List.of(true)));
        }

        @DisplayName("아래로 이동한다.")
        @Test
        void moveDown() {
            BridgeGame bridgeGame = new BridgeGame(upDownUpBridge);
            bridgeGame.move(BridgeShape.DOWN);
            BridgeGameResult result = bridgeGame.result();

            assertThat(result).isEqualTo(new BridgeGameResult(upDownUpBridge, List.of(false)));
        }
    }

    @DisplayName("이동 결과를 반환한다.")
    @Test
    void result() {
        Bridge bridge = Bridge.createByBridgeShapeValue(List.of("U", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move(BridgeShape.UP);
        bridgeGame.move(BridgeShape.DOWN);
        bridgeGame.move(BridgeShape.UP);
        bridgeGame.move(BridgeShape.UP);

        assertThat(bridgeGame.result()).isEqualTo(new BridgeGameResult(bridge, List.of(true, true, true, false)));
    }
}
