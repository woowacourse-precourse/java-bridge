package bridge;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    Bridge bridge;
    GameResult gameResult = new GameResult();
    BridgeGame bridgeGame = new BridgeGame();

    void makeBridge(List<String> bridges) {
        bridge = new Bridge(bridges);
    }

    void moveUp() {
        bridgeGame.move(bridge, gameResult, "U");
    }

    void moveDown() {
        bridgeGame.move(bridge, gameResult, "D");
    }

    @Test
    void 이동_성공_U() {
        makeBridge(List.of("U","U","U"));
        moveUp();
        Assertions.assertThat(gameResult.getResult())
                .containsSubsequence(List.of("O"))
                .doesNotContainSubsequence(List.of("X"));
    }

    @Test
    void 이동_성공_D() {
        makeBridge(List.of("D","D","D"));
        moveDown();
        Assertions.assertThat(gameResult.getResult())
                .containsSubsequence(List.of("O"))
                .doesNotContainSubsequence(List.of("X"));
    }

    @Test
    void 이동_실패_U() {
        makeBridge(List.of("D","D","D"));
        moveUp();
        Assertions.assertThat(gameResult.getResult())
                .containsSubsequence(List.of("X"))
                .doesNotContainSubsequence(List.of("O"));
    }

    @Test
    void 이동_실패_D() {
        makeBridge(List.of("U","U","U"));
        moveDown();
        Assertions.assertThat(gameResult.getResult())
                .containsSubsequence(List.of("X"))
                .doesNotContainSubsequence(List.of("O"));
    }
}