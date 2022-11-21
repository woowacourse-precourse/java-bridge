package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("다리 건너기에 성공했는지 체크하는 메서드")
    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame();
        assertTrue(bridgeGame.move("U", "U"));
    }

    @DisplayName("")
    @Test
    void moveBridge(){
        BridgeGame bridgeGame = new BridgeGame();
        Bridge bridge = new Bridge();
        bridge.setOutputBridge(new ArrayList<>(List.of(new ArrayList<>(List.of(" O ")), new ArrayList<>(List.of("   ")))));
        assertThat(bridgeGame.moveBridge("U", true)).usingRecursiveComparison().isEqualTo(bridge);
    }

}