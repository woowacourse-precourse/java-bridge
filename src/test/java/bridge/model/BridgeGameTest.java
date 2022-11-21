package bridge.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void 이동_테스트() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "D")));
        Assertions.assertEquals(Status.SURVIVE, bridgeGame.move(0, Position.UP));
        Assertions.assertEquals(Status.SURVIVE, bridgeGame.move(1, Position.DOWN));
        Assertions.assertEquals(Status.DIE, bridgeGame.move(2, Position.UP));
    }
}