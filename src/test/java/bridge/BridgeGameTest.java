package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.domain.Result;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

class BridgeGameTest {

    Bridge bridge;
    Player player;
    BridgeGame bridgeGame;
    Result result;

    @DisplayName("길이 3의 브릿지를 생성한다.")
    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "U"));
        player = new Player();
        bridgeGame = new BridgeGame(bridge, player);
        result = new Result();
    }

    @DisplayName("플레이어가 올바른 방향으로 다리를 세차례 건넌다.")
    @Test
    void move() {
        bridgeGame.move(Movement.UP, result);
        bridgeGame.move(Movement.DOWN, result);
        bridgeGame.move(Movement.UP, result);

        assertThat(result.getSuccessOrFailure()).isEqualTo("성공");
    }

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
