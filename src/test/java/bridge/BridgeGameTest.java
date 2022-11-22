package bridge;

import bridge.domain.bridge.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {
    @DisplayName("BridgeGame에 move() 메소드를 실행해본다.")
    @Test
    void testBridgeGameMove() {
        BridgeMaker bridgeMaker = new BridgeMaker(
                new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));

        assertThat(bridgeGame.move("U")).isEqualTo(true);
        assertThat(bridgeGame.move("D")).isEqualTo(true);
        assertThat(bridgeGame.move("U")).isEqualTo(false);
    }


    @DisplayName("BridgeGame에 retry() 메소드를 실행해본다.")
    @Test
    void testBridgeGameRetry() {
        BridgeMaker bridgeMaker = new BridgeMaker(
                new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));

        assertThat(bridgeGame.move("U")).isEqualTo(true);
        assertThat(bridgeGame.move("D")).isEqualTo(true);
        bridgeGame.retry();
        assertThat(bridgeGame.move("U")).isEqualTo(true);
        assertThat(bridgeGame.move("D")).isEqualTo(true);
        assertThat(bridgeGame.move("D")).isEqualTo(true);
    }
}
