package bridge.service;

import bridge.constant.Movement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        List<String> bridge = Arrays.asList("U", "D", "D", "U");
        bridgeGame = new BridgeGame(bridge);
    }

    @Test
    @DisplayName("사용자의 이동 방향과 다리의 이동 가능 방향에 따라 움직인다.")
    void moving() {
        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.move("U")).isFalse();
    }

    @Test
    @DisplayName("움직임에 대한 현재 상태를 생성한다.")
    void creatingMovementStatus() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        String movementStatus = bridgeGame.createMovementStatus();
        assertThat(movementStatus).isEqualTo("[ O |   | X ]\n[   | O |   ]\n");
    }
}