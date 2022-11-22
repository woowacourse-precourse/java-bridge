package bridge.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 다리_이동_테스트() {
        String userMove = "D";
        BridgeSpace bridgeSpace = new BridgeSpace("D");
        System.out.println(bridgeSpace.getMyMoved());
        Moved moved = Moved.CAN;
        BridgeGame bridgeGame = new BridgeGame();
        Moved result = bridgeGame.move(userMove,bridgeSpace);
        System.out.println(result);
        assertThat(result).isEqualTo(moved);
    }

}