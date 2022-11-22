package bridge;

import bridge.UI.output.MapDrawer;
import bridge.enums.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    MapDrawer mapDrawer = new MapDrawer();
    BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U", "U")), mapDrawer);

    @Nested
    @DisplayName("입력한 방향으로 한 칸 이동한다.")
    class MoveTest {
        @Test
        @DisplayName("1개의 stage를 이동한다")
        void increaseStage() {
            int beforeStage = bridgeGame.getStage();
            bridgeGame.move(Direction.UP);
            int afterStage = bridgeGame.getStage();

            assertEquals(1, afterStage - beforeStage);
        }
        @Nested
        @DisplayName("입력한 방향과 해당 칸의 위치를 비교하여")
        class JudgeMoving {
            @Test
            @DisplayName("일치한다면 해당 stage를 pass상태로 업데이트한다.")
            void When_matchDirection_update_stageState_pass() {
                bridgeGame.move(Direction.UP);
                assertTrue(bridgeGame.canMoving());
            }
            @Test
            @DisplayName("일치하지 않는다면 해당 stage를 non-pass상태로 업데이트한다.")
            void When_missMatchDirection_update_stageState_nonPass() {
                bridgeGame.move(Direction.DOWN);
                assertFalse(bridgeGame.canMoving());
            }
        }
        @Test
        @DisplayName("다리의 길이만큼 방향을 모두 맞추면 game을 clear상태로 업데이트한다.")
        void When_allMatchDirectionOfBridge_update_gameState_clear() {
            bridgeGame.move(Direction.UP);
            bridgeGame.move(Direction.DOWN);
            bridgeGame.move(Direction.UP);
            bridgeGame.move(Direction.UP);

            assertTrue(bridgeGame.isCleared());
        }
    }
    
}