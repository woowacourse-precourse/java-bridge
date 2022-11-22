package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame(5);
    }

    @Test
    public void 다리_이동_테스트() {
        bridgeGame.move("U");

        assertThat(bridgeGame.getBridgeDownMemory().get(0)).isEqualTo(" ");
    }
}