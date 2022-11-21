package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgesTest {
    @DisplayName("이동 완료 여부 확인")
    @Test
    void check_is_end() {
        Bridges bridges = new Bridges(3, new BridgeFakeOneZeroLoopNumberGenerator());
        Player player = new Player();
        assertThat(bridges.isCompletedGame(player)).isFalse();
        player.move("U");
        assertThat(bridges.isCompletedGame(player)).isFalse();
        player.move("U");
        player.move("U");
        assertThat(bridges.isCompletedGame(player)).isTrue();
    }

    @DisplayName("특정한 위치의 방향 확인 기능")
    @Test
    void is_same_direction() {
        Bridges bridges = new Bridges(3, new BridgeFakeOneZeroLoopNumberGenerator());
        assertThat(bridges.isRight(1, "U")).isTrue();
        assertThat(bridges.isRight(2, "D")).isTrue();
        assertThat(bridges.isRight(3, "U")).isTrue();
    }
}
