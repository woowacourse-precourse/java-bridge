package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("플레이어를 이동한다.")
    @Test
    void move() {
        Player player = new Player();
        assertThat(player.move("U")).isEqualTo(1);
        assertThat(player.move("U")).isEqualTo(2);
    }

    @DisplayName("이동 완료 여부 확인")
    @Test
    void is_move_complete() {
        Player player = new Player();
        player.move("U");
        player.move("D");
        assertThat(player.isCompletedGame(3)).isFalse();
        assertThat(player.isCompletedGame(2)).isTrue();
    }

    @DisplayName("성공시 리스트 출력")
    @Test
    void print_success_result(){
        Player player = new Player();
        player.move("U");
        player.move("D");
        assertThat(player.printSuccessResult()).isEqualTo("[ O |   ]\n[   | O ]\n");
    }

    @DisplayName("실패시 리스트 출력")
    @Test
    void print_failure_result(){
        Player player = new Player();
        player.move("U");
        player.move("D");
        assertThat(player.printFailureResult()).isEqualTo("[ O |   ]\n[   | X ]\n");
    }
}
