package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private final BridgeGame testBridgeGame = new BridgeGame(new Bridge(List.of("U","D","D")));

    @DisplayName("다리가 이어진 곳으로 건너면 CROSSING 상태를 반환한다.")
    @Test
    void moveCrossingTest() {
        GameState gameState = testBridgeGame.move("U");
        assertThat(gameState.isCrossing()).isTrue();
    }

    @DisplayName("다리가 이어진 곳으로 모두 건너면 CROSSED 상태를 반환한다.")
    @Test
    void moveCrossedTest() {
        testBridgeGame.move("U");
        testBridgeGame.move("D");
        GameState gameState = testBridgeGame.move("D");
        assertThat(gameState.isCrossed()).isTrue();
    }

    @DisplayName("다리가 이어지지 않은 곳으로 건너면 FALL 상태를 반환한다.")
    @Test
    void moveFallTest() {
        GameState gameState = testBridgeGame.move("D");
        assertThat(gameState.isFall()).isTrue();
    }
}
