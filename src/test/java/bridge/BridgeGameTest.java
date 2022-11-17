package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @Test
    @DisplayName("이동한 칸이 이동가능한 칸인지 확인")
    void check_move(){
        BridgeGame bridgeGame = new BridgeGame(4,new BridgeFakeNumberGenerator());
        assertThat(bridgeGame.move("D")).isTrue();
        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.move("U")).isFalse();
        assertThat(bridgeGame.move("D")).isFalse();
    }
}
