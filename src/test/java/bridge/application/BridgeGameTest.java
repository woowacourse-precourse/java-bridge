package bridge.application;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.Bridge;
import bridge.domain.Move;
import bridge.domain.Result;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("사용자가 다리 건너기 게임을 성공합니다.")
    @Test
    void 다리_건너기_게임_성공() {
        Bridge bridge = new Bridge(Arrays.asList("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.move(Move.UP);
        bridgeGame.move(Move.DOWN);
        bridgeGame.move(Move.DOWN);

        Result result = bridgeGame.getResult();

        assertThat(result).isEqualTo(Result.SUCCESS);
    }

    @DisplayName("사용자가 다리 건너기 게임을 실패합니다.")
    @Test
    void 다리_건너기_게임_실패() {
        Bridge bridge = new Bridge(Arrays.asList("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.move(Move.UP);
        bridgeGame.move(Move.DOWN);
        bridgeGame.move(Move.UP);

        Result result = bridgeGame.getResult();

        assertThat(result).isEqualTo(Result.FAIL);
    }

}