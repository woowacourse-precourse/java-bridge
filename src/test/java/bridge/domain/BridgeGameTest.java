package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    @Test
    void moveTest_count3() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U","D","D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        List<String>[] list = bridgeGame.getResult();
        assertThat(list[0]).containsExactly("O", " ", " ");
        assertThat(list[1]).containsExactly(" ", "O" ,"O");
    }
    @Test
    void moveTest_count2() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U","D","D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        List<String>[] list = bridgeGame.getResult();
        assertThat(list[0]).containsExactly("O", " ");
        assertThat(list[1]).containsExactly(" ", "O");
    }
    @Test
    void end_true_test() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U"));
        bridgeGame.move("U");
        assertThat(bridgeGame.isEnd()).isEqualTo(true);
    }
    @Test
    void end_false_test() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U"));
        assertThat(bridgeGame.isEnd()).isEqualTo(false);
    }
    @Test
    void is_fail_test_true() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U"));
        bridgeGame.move("D");
        assertThat(bridgeGame.isGameFail()).isEqualTo(true);
    }
    @Test
    void is_fail_test_false() {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U"));
        bridgeGame.move("U");
        assertThat(bridgeGame.isGameFail()).isEqualTo(false);
    }
}