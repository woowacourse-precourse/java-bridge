package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeGameTest {

    @Test
    void move() {
        UpNumberGenerator upNumberGenerator = new UpNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(upNumberGenerator);
        int size = 1;
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
        MoveResults moveResults = new MoveResults();
        BridgeGame bridgeGame = new BridgeGame(bridge, moveResults);

        bridgeGame.move(0, "U");
        MoveResults movedResult = bridgeGame.moveResults();

        assertThat(movedResult.getMoveResults()).hasSize(1);
    }

    @Test
    void retry() {
    }
}