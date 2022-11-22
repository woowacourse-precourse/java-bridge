package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.CrossStatus;
import bridge.domain.direction.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.domain.bridge.CrossStatus.*;
import static bridge.domain.direction.Direction.DOWN;
import static bridge.domain.direction.Direction.UP;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("뱡향을 받아 다리를 건넌 후, 해당 결과 상태를 반환할 수 있다.")
    @Test
    void crossBridgeAndReturnStatus() {
        // given
        List<Direction> directions = List.of(UP, UP, DOWN, UP, DOWN, DOWN);

        List<CrossStatus> statuses = List.of(GOING, GOING, GOING, GOING, GOING, SUCCESS);

        List<Direction> failDirections = List.of(UP, UP, DOWN, UP, UP);
        List<CrossStatus> failStatuses = List.of(GOING, GOING, GOING, GOING, FAIL);

        Bridge bridge = new Bridge(directions);
        BridgeGame successBridgeGame = new BridgeGame(bridge);
        BridgeGame failBridgeGame = new BridgeGame(bridge);

        // when, then
        for (int i = 0; i < directions.size(); i++) {
            CrossStatus move = successBridgeGame.move(directions.get(i));
            assertThat(move).isEqualTo(statuses.get(i));
        }
        for (int i = 0; i < failDirections.size(); i++) {
            CrossStatus move = failBridgeGame.move(failDirections.get(i));
            assertThat(move).isEqualTo(failStatuses.get(i));
        }
    }

    @DisplayName("retry 시 다리는 유지되며 현재까지 이동한 경로는 초기화된다.")
    @Test
    void retryGameTest() {
        // given
        List<Direction> directions = List.of(DOWN, UP, UP, UP, UP, UP, UP);
        Bridge bridge = new Bridge(directions);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.move(DOWN);
        bridgeGame.move(UP);
        bridgeGame.move(DOWN);
        bridgeGame.move(DOWN);

        // when
        bridgeGame.retry();
        CrossStatus status = bridgeGame.move(DOWN);

        // then
        assertThat(status).isEqualTo(GOING);
    }
}