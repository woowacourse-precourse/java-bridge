package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @Test
    void 다리_이동_테스트_MATCH() {
        BridgeGame bridgeGame = new BridgeGame();
        String bridgeElement = "U";
        String moving = "U";
        assertThat(bridgeGame.move(bridgeElement, moving)).isEqualTo("O");
    }

    @Test
    void 다리_이동_테스트_MISMATCH() {
        BridgeGame bridgeGame = new BridgeGame();
        String bridgeElement = "U";
        String moving = "D";
        assertThat(bridgeGame.move(bridgeElement, moving)).isEqualTo("X");
    }

    @Test
    void 재시도_테스트_RETRY() {
        BridgeGame bridgeGame = new BridgeGame();
        String gameCommand = "R";
        assertThat(bridgeGame.retry(gameCommand)).isEqualTo(1);
    }

    @Test
    void 재시도_테스트_QUIT() {
        BridgeGame bridgeGame = new BridgeGame();
        String gameCommand = "Q";
        assertThat(bridgeGame.retry(gameCommand)).isEqualTo(0);
    }
}