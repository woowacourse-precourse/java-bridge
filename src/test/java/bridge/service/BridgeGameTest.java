package bridge.service;

import bridge.constant.Movement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @Test
    @DisplayName("사용자의 이동 방향과 다리의 이동 가능 방향에 따라 움직인다.")
    void moving() {
        List<String> bridge = Arrays.asList("U", "D", "D", "U");
        BridgeGame game = new BridgeGame(bridge);

        assertThat(game.move("U")).isTrue();
        assertThat(game.move("U")).isFalse();
    }

    @Test
    @DisplayName("움직임에 대한 현재 상태를 생성한다.")
    void creatingMovementStatus() {
        List<String> bridge = Arrays.asList("U", "D", "D", "U");
        BridgeGame game = new BridgeGame(bridge);
        game.move("U");
        game.move("D");
        game.move("U");
        String movementStatus = game.createMovementStatus();
        assertThat(movementStatus).isEqualTo("[ O |   | X ]\n[   | O |   ]\n");
    }
}