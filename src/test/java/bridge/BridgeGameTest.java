package bridge;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    @Test
    void userInputUpTest1() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.uplist("U", "U");
        assertThat(bridgeGame.upBridge).isEqualTo(List.of("[ ", "O", " ]"));
        assertThat(bridgeGame.downBridge).isEqualTo(List.of("[ ", " ", " ]"));
    }
    @Test
    void userInputDownTest1() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.downlist("D", "D");
        assertThat(bridgeGame.upBridge).isEqualTo(List.of("[ ", " ", " ]"));
        assertThat(bridgeGame.downBridge).isEqualTo(List.of("[ ", "O", " ]"));
    }
    @Test
    void userInputUpTest2() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.uplist("D", "U");
        assertThat(bridgeGame.upBridge).isEqualTo(List.of("[ ", "X", " ]"));
        assertThat(bridgeGame.downBridge).isEqualTo(List.of("[ ", " ", " ]"));
    }
    @Test
    void userInputDownTest2() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.downlist("U", "D");
        assertThat(bridgeGame.upBridge).isEqualTo(List.of("[ ", " ", " ]"));
        assertThat(bridgeGame.downBridge).isEqualTo(List.of("[ ", "X", " ]"));
    }
    @Test
    void midStickTest(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.midStick();
        assertThat(bridgeGame.upBridge).contains(" | ");
        }

    @Test
    void retryTest(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.upBridge = new ArrayList<>(List.of("[ ", "O", " | ", " ]"));
        bridgeGame.downBridge = new ArrayList<>(List.of("[ ", " ", " | ", " ]"));
        bridgeGame.retry(5,0, "R");
        assertThat(bridgeGame.count).isEqualTo(2);
        assertThat(bridgeGame.upBridge).isEqualTo(List.of("[ ", " ]"));
        assertThat(bridgeGame.downBridge).isEqualTo(List.of("[ ", " ]"));
    }

    @Test
    void moveTest(){
        BridgeGame bridgeGame = new BridgeGame();
    }

}
