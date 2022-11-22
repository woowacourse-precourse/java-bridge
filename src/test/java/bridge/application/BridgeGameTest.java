package bridge.application;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.Bridge;
import bridge.domain.GameCommand;
import bridge.domain.GameStatus;
import bridge.domain.Move;
import bridge.domain.Moving;
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

    @DisplayName("이동한 다리의 위치가 동일하면 이동 테스트를 성공합니다.")
    @Test
    void 다리_이동_테스트_성공() {
        Bridge bridge = new Bridge(Arrays.asList("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.move(Move.UP);
        Result result = bridgeGame.getMoving().getResult();

        assertThat(result).isEqualTo(Result.SUCCESS);
    }

    @DisplayName("이동한 다리의 위치가 동일하지 않으면 이동 테스트를 실패합니다.")
    @Test
    void 다리_이동_테스트_실패() {
        Bridge bridge = new Bridge(Arrays.asList("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        Moving moving = bridgeGame.move(Move.DOWN);
        Result result = moving.getResult();

        assertThat(result).isEqualTo(Result.FAIL);
    }

    @DisplayName("다리 건너기 게임 재시도 시 초기화 설정")
    @Test
    void 다리_이동_테스트_재시도() {
        Bridge bridge = new Bridge(Arrays.asList("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.move(Move.UP);
        bridgeGame.retry();

        initializeTest(bridgeGame);
    }

    @DisplayName("GameCommand가 RETRY일 때, BridgeGame을 초기화 시키고 GameStatus.RETRY를 반환합니다.")
    @Test
    void 게임_커맨드_RETRY_테스트() {
        Bridge bridge = new Bridge(Arrays.asList("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        GameStatus gameStatus = bridgeGame.getGameStatusByGameCommand(GameCommand.RETRY);

        initializeTest(bridgeGame);
        assertThat(gameStatus).isEqualTo(GameStatus.RETRY);
    }

    @DisplayName("GameCommand가 QUIT일 때, GameStatus.QUIT를 반환합니다.")
    @Test
    void 게임_커맨드_QUIT_테스트() {
        Bridge bridge = new Bridge(Arrays.asList("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        GameStatus gameStatus = bridgeGame.getGameStatusByGameCommand(GameCommand.QUIT);

        assertThat(gameStatus).isEqualTo(GameStatus.QUIT);
    }

    private void initializeTest(BridgeGame bridgeGame) {
        assertThat(bridgeGame.getCount().getCount()).isEqualTo(2);
        assertThat(bridgeGame.getMoving().getMovingResult(Move.UP).size()).isEqualTo(0);
        assertThat(bridgeGame.getMoving().getMovingResult(Move.DOWN).size()).isEqualTo(0);
    }

}