package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @DisplayName("다리 한 칸을 성공적으로 건넜는지 확인하는 기능에 대한 테스트")
    @Test
    public void checkCurrentStatusTest() {
        BridgeGame game = new BridgeGame(List.of("U", "U", "U"));
        assertThat(game.checkCurrentStatus()).isTrue();
        game.move("U");
        assertThat(game.checkCurrentStatus()).isTrue();
        game.move("D");
        assertThat(game.checkCurrentStatus()).isFalse();
    }

    @DisplayName("다리를 다 건넜는지 확인하는 기능에 대한 테스트")
    @Test
    public void checkIfWinTest() {
        BridgeGame game = new BridgeGame(List.of("U", "D", "U"));
        assertThat(game.checkIfWin()).isFalse();
        game.move("U");
        assertThat(game.checkIfWin()).isFalse();
        game.move("D");
        assertThat(game.checkIfWin()).isFalse();
        game.move("U");
        assertThat(game.checkIfWin()).isTrue();
    }
}
