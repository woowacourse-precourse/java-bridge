package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("U 혹은 D를 입력하면 사용자는 다리를 이동한다.")
    @Test
    void moveBridge() {
        game.move("U");
        assertThat(bridge.getDistance()).isEqualTo(1);
    }
}
