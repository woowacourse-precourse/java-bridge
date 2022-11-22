package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {


    @DisplayName("맞을 시 true 반환 Test")
    @Test
    public void moveReturnTrueTest() throws Exception {
        BridgeGame bridgeGame = new BridgeGame();
        boolean move = bridgeGame.move(List.of("U","U","U"), "U",0);
        assertThat(move).isTrue();
    }

    @DisplayName("맞지 않을 시 false 반환 Test")
    @Test
    public void moveReturnFalseTest() throws Exception {
        BridgeGame bridgeGame = new BridgeGame();
        boolean move = bridgeGame.move(List.of("D"), "U",0);
        assertThat(move).isFalse();
    }

}
