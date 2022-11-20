package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("플레이어를 이동하고 이동거리를 반환")
    @Test
    void move() {
        Player player = new Player();
        assertThat(player.move("U")).isEqualTo(1);
        assertThat(player.move("U")).isEqualTo(2);
    }

    @DisplayName("이동 완료 여부 확인")
    @Test
    void is_completed() {
        Player player = new Player();
        player.move("U");
        player.move("D");
        assertThat(player.isCompletedGame(3)).isFalse();
        assertThat(player.isCompletedGame(2)).isTrue();
    }

    @DisplayName("이동 전 상태 확인")
    @Test
    void is_start_status() {
        Player player = new Player();
        assertThat(player.isStartStatus()).isTrue();
        player.move("U");
        assertThat(player.isStartStatus()).isFalse();
    }

    @DisplayName("성공시 리스트 출력")
    @Test
    void print_success_result() {
        Player player = new Player();
        player.move("U");
        player.move("D");
        assertThat(player.printSuccessResult()).isEqualTo("[ O |   ]\n[   | O ]\n");
    }

    @DisplayName("실패시 리스트 출력")
    @Test
    void print_failure_result() {
        Player player = new Player();
        player.move("U");
        player.move("D");
        assertThat(player.printFailureResult()).isEqualTo("[ O |   ]\n[   | X ]\n");
    }
}
