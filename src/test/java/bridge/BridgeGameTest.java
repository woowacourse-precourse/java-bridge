package bridge;

import bridge.model.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    @DisplayName("입력된 이동값과 다리정보가 같다면 true를 리턴")
    @Test
    void 입력된_이동값과_다리정보의_값이_같음(){
        BridgeGame game = new BridgeGame(List.of("U","D","U"));
        assertThat(true).isEqualTo(game.move("U"));
        assertThat(true).isEqualTo(game.move("D"));
        assertThat(true).isEqualTo(game.move("U"));
    }
    @DisplayName("입력된 이동값과 다리정보가 다르면 false를 리턴")
    @Test
    void 입력된_이동값과_다리정보의_값이_다름(){
        BridgeGame game = new BridgeGame(List.of("U","D","U"));
        assertThat(false).isEqualTo(game.move("D"));
    }
}