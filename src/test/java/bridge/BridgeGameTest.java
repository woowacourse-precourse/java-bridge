package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    BridgeGame game = new BridgeGame();

    @Test
    @DisplayName("사용자가 이동할 수 있는 칸을 선택한 경우")
    void move_이동가능() {
        game.step = 0;
        Boolean moveResult = game.move(List.of("U", "D", "D"), "U");
        assertThat(moveResult).isEqualTo(Boolean.TRUE);
    }

    @Test
    @DisplayName("사용자가 이동할 수 있는 칸을 선택한 경우")
    void move_이동가능2() {
        game.step = 2;
        Boolean moveResult = game.move(List.of("U", "D", "D"), "D");
        assertThat(moveResult).isEqualTo(Boolean.TRUE);
    }

    @Test
    @DisplayName("사용자가 이동할 수 없는 칸을 선택한 경우")
    void move_이동불가() {
        game.step = 0;
        Boolean moveResult = game.move(List.of("U", "D", "D"), "D");
        assertThat(moveResult).isEqualTo(Boolean.FALSE);
    }

    @Test
    @DisplayName("사용자가 이동할 수 없는 칸을 선택한 경우")
    void move_이동불가2() {
        game.step = 1;
        Boolean moveResult = game.move(List.of("U", "D", "D", "U"), "U");
        assertThat(moveResult).isEqualTo(Boolean.FALSE);
    }
}