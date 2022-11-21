package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void creatingMovementMap() {
        Arrays.asList("U", "D", "U").forEach(movement -> bridgeGame.move(movement));
        String movementMap = bridgeGame.createMovementMap();
        assertThat(movementMap).isEqualTo("[ O |   | X ]\n[   | O |   ]\n");
    }

    @Test
    @DisplayName("다리를 완전히 건넜는지 확인한다.")
    void crossingBridge() {
        Arrays.asList("U", "D", "D", "U").forEach(movement -> bridgeGame.move(movement));
        assertThat(bridgeGame.crossedBridge()).isTrue();
    }

    @Test
    @DisplayName("게임을 재시도하고 다리 상태를 확인하며 예외를 던진다.")
    void retry() {
        bridgeGame.retry();
        assertThatThrownBy(() -> bridgeGame.createMovementMap())
                .isInstanceOf(IllegalArgumentException.class);
    }
}