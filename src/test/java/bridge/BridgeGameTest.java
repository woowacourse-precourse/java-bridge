package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @Test
    void 값이_잘_들어가는지(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.init(4);
        Assertions.assertThat(bridgeGame.move("D")).isNotEmpty();
    }

    @Test
    void reTry(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.init(4);
        bridgeGame.retry("R");
        Assertions.assertThat(bridgeGame.getRetryCount()).isEqualTo(2);
    }
}
