package bridge;

import static org.assertj.core.api.Assertions.as;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.domain.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

class BridgeGameTest {
    Bridge bridge;
    Player player;
    BridgeGame bridgeGame = new BridgeGame(bridge, player);
    Result result = new Result();

    @DisplayName("retry()를 실행하면 시도 횟수가 2로 올라감")
    @Test
    void updateTrialNumberTestFromRetry() {

        bridgeGame.retry(result);

        assertThat(result.getNumberOfTrials()).isEqualTo(2);
    }

    @DisplayName("retry()를 실행하면 이동 경로가 초기화 됨")
    @Test
    void initRouteFromRetry() {
        player.updateMovement(Movement.UP);

        bridgeGame.retry(result);

        assertThat(player.getRoute()).isEqualTo(new ArrayList<>());
    }

    @DisplayName("retry()를 실행하면 기존에 생성된 결과값이 초기화 됨")
    @Test
    void initResultFromRetry() {
        result.setGameResult(Boolean.TRUE);

        bridgeGame.retry(result);

        assertThat(result.getGameResult()).isEqualTo(new ArrayList<>());
    }
}
