package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    @Test
    void test() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "U", "D"));
        bridgeGame.move("U");
        System.out.println(bridgeGame);
        assertThat(bridgeGame.getPosition()).isEqualTo(0);
        assertThat(bridgeGame.getUpBridgeStatus()).containsExactly('O', ' ', ' ');
    }

}