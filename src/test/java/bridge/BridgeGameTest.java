package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void move() {
        UpNumberGenerator upNumberGenerator = new UpNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(upNumberGenerator);
        int size = 3;
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
        MoveResults moveResults = new MoveResults();
        BridgeGame bridgeGame = new BridgeGame(bridge, moveResults);
        MoveResult success = new MoveResult("U", true);
        MoveResult failure = new MoveResult("D", false);

        bridgeGame.move("U");
        bridgeGame.move("D");
        MoveResults movedResult = bridgeGame.moveResults();

        assertAll(() -> assertThat(movedResult.getMoveResults()).hasSize(2),
                () -> assertThat(movedResult.getMoveResults()).contains(success),
                () -> assertThat(movedResult.getMoveResults()).contains(failure));
    }

    @Test
    void retry() {
        UpNumberGenerator upNumberGenerator = new UpNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(upNumberGenerator);
        int size = 3;
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
        MoveResults moveResults = new MoveResults();
        BridgeGame bridgeGame = new BridgeGame(bridge, moveResults);
        MoveResult success = new MoveResult("U", true);

        bridgeGame.move("D");
        bridgeGame.retry("U");
        MoveResults retryResult = bridgeGame.moveResults();

        assertAll(() -> assertThat(retryResult.size()).isEqualTo(1),
                () -> assertThat(retryResult.getMoveResults()).contains(success));
    }
}