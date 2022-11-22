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
        assertThat(bridgeGame.getUpBridgeUserAnswerTable()).containsExactly("O", "O", "X");
        assertThat(bridgeGame.getDownBridgeUserAnswerTable()).containsExactly(" ", " ", " ");
    }

    @Test
    void moveCase2() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.getUpBridgeUserAnswerTable()).containsExactly("O", "O", " ");
        assertThat(bridgeGame.getDownBridgeUserAnswerTable()).containsExactly(" ", " ", "O");
    }

    @Test
    void moveCase3() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.getUpBridgeUserAnswerTable()).containsExactly("O", " ");
        assertThat(bridgeGame.getDownBridgeUserAnswerTable()).containsExactly(" ", "X");
    }

    @Test
    void moveTest() {
        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.move("D")).isFalse();
    }

    @Test
    void createUserBridge() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.getUpBridgeUserAnswerTable()).containsExactly("O", " ");
        assertThat(bridgeGame.getDownBridgeUserAnswerTable()).containsExactly(" ", "X");
    }

    @Test
    void retryTest() {
        bridgeGame.retry();
        assertThat(bridgeGame.getUpBridgeUserAnswerTable()).isEmpty();
        assertThat(bridgeGame.getDownBridgeUserAnswerTable()).isEmpty();
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
    }
}