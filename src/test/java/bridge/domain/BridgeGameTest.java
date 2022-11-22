package bridge.domain;

import bridge.domain.BridgeGame;
import bridge.domain.UserResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {
    @Test
    void createTrueMoveByBridgeGame() {
        String inputBridge = "U";
        String rightBridge = "U";
        boolean expect = true;

        UserResult userResult = new UserResult();
        BridgeGame bridgeGame = new BridgeGame();
        assertThat(bridgeGame.move(userResult, inputBridge, rightBridge)).isEqualTo(expect);
    }

    @Test
    void createFalseMoveByBridgeGame() {
        String inputBridge = "U";
        String rightBridge = "D";
        boolean expect = false;

        UserResult userResult = new UserResult();
        BridgeGame bridgeGame = new BridgeGame();
        assertThat(bridgeGame.move(userResult, inputBridge, rightBridge)).isEqualTo(expect);
    }

    @Test
    void createTrueRetryByBridgeGame() {
        String inputRetry = "R";
        boolean expect = true;

        BridgeGame bridgeGame = new BridgeGame();
        assertThat(bridgeGame.retry(inputRetry)).isEqualTo(expect);
    }

    @Test
    void createFalseRetryByBridgeGame() {
        String inputRetry = "Q";
        boolean expect = false;

        BridgeGame bridgeGame = new BridgeGame();
        assertThat(bridgeGame.retry(inputRetry)).isEqualTo(expect);
    }
}