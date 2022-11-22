package bridge.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void Retry_여부() {
        BridgeGame bridgeGame = new BridgeGame();
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }
}