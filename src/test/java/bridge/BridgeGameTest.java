package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void createBridgeGame() {
        bridgeGame = new BridgeGame(List.of("U","D","D"));
    }

    @DisplayName("올바른 다리를 건넌 경우 true 반환")
    @Test
    void moveCorrectBridge() {
        assertThat(bridgeGame.move("U")).isTrue();
    }

    @DisplayName("올바른 다리가 아닌 경우 false 반환")
    @Test
    void moveIncorrectBridge() {
        assertThat(bridgeGame.move("D")).isFalse();
    }


}
