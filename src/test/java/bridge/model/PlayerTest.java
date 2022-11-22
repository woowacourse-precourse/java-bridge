package bridge.model;

import static bridge.model.Position.DOWN;
import static bridge.model.Position.UP;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void setPlayer() {
        player = new Player();
    }

    @DisplayName("플레이어를 이동하고 이동거리를 반환")
    @Test
    void move() {
        assertThat(player.move(UP)).isEqualTo(1);
        assertThat(player.move(UP)).isEqualTo(2);
    }

    @DisplayName("이동 완료 여부 확인")
    @Test
    void is_completed() {
        player.move(UP);
        player.move(DOWN);
        assertThat(player.isCompletedGame(3)).isFalse();
        assertThat(player.isCompletedGame(2)).isTrue();
    }

    @DisplayName("이동 전 상태 확인")
    @Test
    void is_start_status() {
        assertThat(player.isStartStatus()).isTrue();

        player.move(UP);
        assertThat(player.isStartStatus()).isFalse();
    }

    @DisplayName("결과 출력")
    @Test
    void print_result() {
        player.move(UP);
        player.move(DOWN);

        assertThat(player.printResult(true)).isEqualTo("[ O |   ]\n[   | O ]\n");
        assertThat(player.printResult(false)).isEqualTo("[ O |   ]\n[   | X ]\n");
    }
}
