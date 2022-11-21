package bridge;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeGame;
import bridge.domain.player.Player;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BridgeGameTest {
    BridgeGame bridgeGame;
    @Before
    public void setUp(){
        bridgeGame = new BridgeGame();
    }
    @DisplayName("makeBridge Test")
    @Test
    public void makeBridgeTest(){
        assertThat(bridgeGame.makeBridge(3)).isEqualTo(3);
    }

    @DisplayName("move Test")
    @Test
    public void moveBridgeTest(){
        Bridge bridge = new Bridge();
        bridge.inputBridgeSize(3);
        bridge.inputBridgeNumber();
        Player player = new Player();
        player.setInputMoving("U");
        assertThat(bridgeGame.move(0)).isEqualTo(true);
    }
}
