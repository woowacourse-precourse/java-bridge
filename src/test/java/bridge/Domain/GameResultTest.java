package bridge.Domain;

import bridge.EnumCollections.BridgeResultType;
import bridge.EnumCollections.BridgeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private GameResult gameResult;

    @Nested
    @DisplayName("isPositionUpper 메소드 테스트")
    class TestIsPositionUpper {

        @Test
        @DisplayName("플레이어가 위쪽으로 이동한 경우 true 리턴")
        void isPositionUpper_playerMoveUpperBridge_returnTrue() {
            gameResult = new GameResult(BridgeType.UP, BridgeResultType.POSSIBLE);
            assertThat(gameResult.isPositionUpper()).isTrue();
        }

        @Test
        @DisplayName("플레이어가 아래쪽으로 이동한 경우")
        void isPositionUpper_playerMoveLowerBridge_returnFalse() {
            gameResult = new GameResult(BridgeType.DOWN, BridgeResultType.POSSIBLE);
            assertThat(gameResult.isPositionUpper()).isFalse();
        }
    }

    @Nested
    @DisplayName("isGameSuccess 메소드 테스트")
    class TestIsGameSuccess {

        @Test
        @DisplayName("플레이어가 이동을 성공한 경우 true 리턴")
        void isMoveSuccess_playerMoveSucess_returnTrue() {
            gameResult = new GameResult(BridgeType.UP, BridgeResultType.POSSIBLE);
            assertThat(gameResult.isMoveSuccess()).isTrue();
        }

        @Test
        @DisplayName("플레이어가 이동을 실패한 경우 false 리턴")
        void isMoveSuccess_playerMoveFail_returnFalse() {
            gameResult = new GameResult(BridgeType.DOWN, BridgeResultType.IMPOSSIBLE);
            assertThat(gameResult.isMoveSuccess()).isFalse();
        }
    }
}