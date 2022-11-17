package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    private void setUp() {
        bridgeGame = new BridgeGame();
    }

    @Test
    void moveTest() {
        Bridge bridge = Bridge.from(List.of("U", "D", "D", "U", "D"));
        Player player = new Player();

        bridgeGame.move(bridge, player, BridgeTile.UP);
        bridgeGame.move(bridge, player, BridgeTile.DOWN);
        boolean actualResult = bridgeGame.move(bridge, player, BridgeTile.DOWN);

        boolean expectedResult = true;

        assertThat(actualResult).isEqualTo(expectedResult);
    }

}