package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void initBridgeGame() {
        List<String> testBridge = new ArrayList<>();
        testBridge.add("U");
        testBridge.add("U");
        testBridge.add("D");
        bridgeGame = new BridgeGame(testBridge);
    }

    @Test
    void moveCase1() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.getUserAnswerTable()).containsExactly("O", "O", "X");
    }

    @Test
    void moveCase2() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.getUserAnswerTable()).containsExactly("O", "O", "O");
    }

    @Test
    void retry() {
    }
}