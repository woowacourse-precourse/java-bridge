package bridge.domain;

import bridge.CrossResult;
import bridge.UpNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeGameTest {

    @Test
    void move() {
        UpNumberGenerator upNumberGenerator = new UpNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(upNumberGenerator);
        int size = 3;
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, size);
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
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, size);
        MoveResult success = new MoveResult("U", true);

        bridgeGame.move("D");
        bridgeGame.retry();
        bridgeGame.move("U");
        MoveResults retryResult = bridgeGame.moveResults();
        List<String> upMap = bridgeGame.upMap();

        assertAll(() -> assertThat(retryResult.size()).isEqualTo(1),
                () -> assertThat(retryResult.getMoveResults()).containsOnly(success),
                () ->assertThat(retryResult.getTryNum()).isEqualTo(2),
                () -> assertThat(upMap).containsOnly(CrossResult.Success.getSuccessFailureLetter()));
    }

    @Test
    void upMap() {
        UpNumberGenerator upNumberGenerator = new UpNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(upNumberGenerator);
        int size = 3;
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, size);
        bridgeGame.move("U");
        bridgeGame.move("D");
        List<String> upMap = bridgeGame.upMap();

        assertAll(() -> assertThat(upMap).hasSize(2),
                () -> assertThat(upMap.get(0)).isEqualTo(CrossResult.Success.getSuccessFailureLetter()),
                () -> assertThat(upMap.get(1)).isEqualTo(CrossResult.NONE.getSuccessFailureLetter()));


    }

    @Test
    void downMap() {
        UpNumberGenerator upNumberGenerator = new UpNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(upNumberGenerator);
        int size = 3;
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, size);
        bridgeGame.move("U");
        bridgeGame.move("D");
        List<String> downMap = bridgeGame.downMap();

        assertAll(() -> assertThat(downMap).hasSize(2),
                () -> assertThat(downMap.get(0)).isEqualTo(CrossResult.NONE.getSuccessFailureLetter()),
                () -> assertThat(downMap.get(1)).isEqualTo(CrossResult.FAIL.getSuccessFailureLetter()));
    }
}