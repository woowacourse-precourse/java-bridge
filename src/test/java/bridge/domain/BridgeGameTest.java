package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("다리 이동 테스트")
    @Test
    void moveBridge() {
        Bridge bridge = new Bridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        BridgeMap u = bridgeGame.move("U");
        System.out.println(u.getMap());
    }

}