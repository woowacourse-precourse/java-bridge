package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    @Test
    @DisplayName("입력받은 방향으로 이동이 가능하다.")
    void moveWithInputMovement() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        assertThat(bridgeGame.getPlayer()).isEqualTo(List.of("U", "D", "D"));
    }

    @Test
    @DisplayName("U와 D이외의 입력으론 움직이지 않는다.")
    void moveWithDigitInput() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));

        assertThatThrownBy(() -> bridgeGame.move("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}