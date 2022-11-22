package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(3);
    }

    @Test
    void mapSizeTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");

        assertThat(bridgeGame.getLog().getMap(0).size()).isEqualTo(2);
    }

    @Test
    void retryTest() {
        bridgeGame.move("U");
        bridgeGame.move("U");

        bridgeGame.retry();

        assertThat(bridgeGame.getRound()).isEqualTo(0);
    }

}