package bridge;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeGame;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BridgeGameTest{
    BridgeGame bridgeGame;
    @Before
    public void setUp(){
        bridgeGame = new BridgeGame();
    }

    @DisplayName("makeBridge Test")
    @Test
    public void makeBridgeTest(){
        bridgeGame.makeBridge(3);
        assertThat(bridgeGame.getBridge()).isNotNull();
    }
    @DisplayName("makePlayer Test")
    @Test
    public void makePlayerTest(){
        bridgeGame.makePlayer("U");
        assertThat(bridgeGame.getPlayer()).isNotNull();
    }
    @DisplayName("move Test")
    @Test
    public void moveBridgeTest(){
        bridgeGame.makeBridge(3);
        bridgeGame.makePlayer("U");
        Bridge bridge = bridgeGame.getBridge();
        assertThat(bridgeGame.move(0).getResultType().getWinLose()).isEqualTo(bridge.getBridgeNumber().getBridgeNumber(0).equals("U"));
    }
    @DisplayName("retry Test")
    @Test
    public void retryBridgeTest(){
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
    }
}
