package bridge;

import bridge.domain.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    BridgeGame bridgeGame;
    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }


    @Test
    void matchTest(){
        String match = bridgeGame.match("U", "D");

        assertThat(match).isEqualTo("X");
    }
}