package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

        @DisplayName("다리보다 많이 이동하면 예외 처리한다.")
        @Test
        void moveException() {
            BridgeGame bridgeGame = new BridgeGame(upDownUpBridge);
            bridgeGame.move(BridgeShape.DOWN);
            bridgeGame.move(BridgeShape.DOWN);
            bridgeGame.move(BridgeShape.DOWN);

            assertThatThrownBy(() -> bridgeGame.move(BridgeShape.DOWN)).isInstanceOf(IllegalArgumentException.class);
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

    @DisplayName("게임 시도 횟수를 반환한다.")
    @Test
    void tryCount() {
        Bridge bridge = Bridge.createByBridgeShapeValue(List.of("U", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        BridgeGame retryBridgeGame = bridgeGame.retry();

        assertAll(
                () -> assertThat(bridgeGame.tryCount()).isEqualTo(new TryCount(1)),
                () -> assertThat(retryBridgeGame.tryCount()).isEqualTo(new TryCount(2))
        );
    }

    @DisplayName("게임을 재시작한다.")
    @Test
    void retry() {
        Bridge bridge = Bridge.createByBridgeShapeValue(List.of("U", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move(BridgeShape.UP);
        bridgeGame.move(BridgeShape.DOWN);

        assertThat(bridgeGame.retry()).isEqualTo(new BridgeGame(bridge, new TryCount(2)));
    }

    @DisplayName("게임이 안끝났는지 반환한다.")
    @Nested
    class isNotEnd {
        @DisplayName("게임이 끝나지 않았으면 True 를 반환한다.")
        @Test
        void isNotEndTrue() {
            BridgeGame bridgeGame = new BridgeGame(upDownUpBridge);
            bridgeGame.move(BridgeShape.UP);
            bridgeGame.move(BridgeShape.DOWN);

            assertThat(bridgeGame.isNotEnd()).isTrue();
        }

        @DisplayName("게임이 끝났으면 False 를 반환한다.")
        @Test
        void isNotEndFalse() {
            BridgeGame bridgeGame = new BridgeGame(upDownUpBridge);
            bridgeGame.move(BridgeShape.UP);
            bridgeGame.move(BridgeShape.DOWN);
            bridgeGame.move(BridgeShape.UP);

            assertThat(bridgeGame.isNotEnd()).isFalse();
        }
    }
}
