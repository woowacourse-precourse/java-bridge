package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame();
    }

    @Test
    void 칸_이동_테스트() {
        bridgeGame.setAnswerBridge(newArrayList("U", "D", "U"));
        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.move("D")).isFalse();
    }
}