package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    Bridge bridge = new Bridge(List.of(Moving.U, Moving.U, Moving.D));
    Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player();
    }

    @DisplayName("이동할 칸 맞추면 플레이어 상태: MOVING")
    @Test
    void move_메서드는_이동할_칸을_맞추면_자신의_상태를_MOVING으로_변경한다() {
        player.move(Moving.U, bridge);
        assertThat(player.isMoving()).isTrue();
    }

    @DisplayName("이동할 칸 틀리면 플레이어 상태: DEAD")
    @Test
    void move_메서드는_이동할_칸을_틀리면_자신의_상태를_DEAD로_변경한다() {
        player.move(Moving.D, bridge);
        assertThat(player.isDead()).isTrue();
    }

    @DisplayName("마지막 칸까지 맞추면 플레이어 상태: CROSSED")
    @Test
    void move_메서드는_마지막_칸을_맞추면_자신의_상태를_CROSSED로_변경한다() {
        player.move(Moving.U, bridge);
        player.move(Moving.U, bridge);
        player.move(Moving.D, bridge);
        assertThat(player.isCrossedBridge()).isTrue();
    }
}