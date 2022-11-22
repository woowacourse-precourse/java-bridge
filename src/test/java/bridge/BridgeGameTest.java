package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("유저 : U / 다리 : U -> True")
    @Test
    void 다리_건너기_테스트1() {
        BridgeGame bridgeGame = new BridgeGame();
        String testBridge = "U";
        Boolean test = bridgeGame.move("U",testBridge);
        assertThat(test).isTrue();
    }

    @DisplayName("유저 : U / 다리 : D -> False")
    @Test
    void 다리_건너기_테스트2() {
        BridgeGame bridgeGame = new BridgeGame();
        String testBridge = "D";
        Boolean test = bridgeGame.move("U",testBridge);
        assertThat(test).isFalse();
    }

    @DisplayName("유저 : D / 다리 : U -> False")
    @Test
    void 다리_건너기_테스트3() {
        BridgeGame bridgeGame = new BridgeGame();
        String testBridge = "U";
        Boolean test = bridgeGame.move("D",testBridge);
        assertThat(test).isFalse();
    }

    @DisplayName("유저 : D / 다리 : D -> True")
    @Test
    void 다리_건너기_테스트4() {
        BridgeGame bridgeGame = new BridgeGame();
        String testBridge = "D";
        Boolean test = bridgeGame.move("D",testBridge);
        assertThat(test).isTrue();
    }

    @DisplayName("유저 : Q -> False")
    @Test
    void 재시작_테스트1() {
        BridgeGame bridgeGame = new BridgeGame();
        String User = "Q";
        Boolean test = bridgeGame.retry(User);
        assertThat(test).isFalse();
    }

    @DisplayName("유저 : R -> True")
    @Test
    void 재시작_테스트2() {
        BridgeGame bridgeGame = new BridgeGame();
        String User = "R";
        Boolean test = bridgeGame.retry(User);
        assertThat(test).isTrue();
    }

}