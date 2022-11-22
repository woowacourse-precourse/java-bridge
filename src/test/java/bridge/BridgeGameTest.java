package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.etc.GameState;
import bridge.game.Bridge;
import bridge.game.BridgeGame;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    private BridgeGame game;
    private Bridge bridge;

    @BeforeEach
    void setGame() {
        this.bridge = new Bridge(List.of("U", "U", "U"));
        this.game = new BridgeGame(bridge);
    }

    @DisplayName("이동에서 U 혹은 D가 아닌 값이 입력되면 예외를 발생시킨다.")
    @Test
    void moveBridgeByWrongInput() {
        assertThatThrownBy(() -> game.move("W"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동을 위해 길이가 1 이상인 입력이 발생하면 예외를 발생시킨다.")
    @Test
    void moveBridgeByLongInput() {
        assertThatThrownBy(() -> game.move("UU"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U 혹은 D를 입력하면 사용자는 다리를 이동한다.")
    @Test
    void moveBridge() {
        game.move("U");
        assertThat(bridge.getDistance()).isEqualTo(1);
    }

    @DisplayName("다리를 끝까진 건너면 게임이 종료된다.")
    @Test
    void clearGame() {
        game.move("U");
        game.move("U");

        assertThat(game.move("U")).isEqualTo(GameState.CLEAR);
    }

    @DisplayName("다리를 건너다 잘못 선택한 경우 실패로 상태를 전환한다.")
    @Test
    void failGame() {
        assertThat(game.move("D")).isEqualTo(GameState.FAIL);
    }

    @DisplayName("재시작 여부 입력 시 R 또는 Q 이외의 값은 예외를 발생한다.")
    @Test
    void retryGameWithWrongInput() {
        assertThatThrownBy(() -> game.move("W"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 여부 입력 시 1개 길이가 아닌 문자 입력은 예외를 발생한다.")
    @Test
    void retryGameWithLongInput() {
        assertThatThrownBy(() -> game.move("QQ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작을 입력한 경우 게임을 재시작한다.")
    @Test
    void retryGame() {
        assertThat(game.retry("R")).isEqualTo(GameState.CONTINUE);
    }

    @DisplayName("종료를 입력한 경우 게임을 종료한다.")
    @Test
    void closeGame() {
        assertThat(game.retry("Q")).isEqualTo(GameState.EXIT);
    }
}
