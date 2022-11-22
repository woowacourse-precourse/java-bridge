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

    @DisplayName("다리 건너기의 결과에 따라 O 또는 X를 이용하여 출력할 다리를 생성하는 메서드")
    @Test
    void moveBridge(){
        BridgeGame bridgeGame = new BridgeGame();
        Bridge bridge = new Bridge();
        bridge.setOutputBridge(new ArrayList<>(List.of(new ArrayList<>(List.of(" O ")), new ArrayList<>(List.of("   ")))));
        assertThat(bridgeGame.moveBridge("U", true)).usingRecursiveComparison().isEqualTo(bridge);
    }

    @DisplayName("사용자가 게임을 다시 시도할 때 사용하는 메서드")
    @Test
    void retry(){
        BridgeGame bridgeGame = new BridgeGame();
        assertTrue(bridgeGame.retry("R"));
    }

}