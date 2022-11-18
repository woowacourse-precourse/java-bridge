package bridge.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}