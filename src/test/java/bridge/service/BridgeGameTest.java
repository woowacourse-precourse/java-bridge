package bridge.service;

import bridge.BridgeMark;
import bridge.GameStatus;
import bridge.TestBridgeNumberGenerator;
import bridge.dto.GameResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        bridgeGame.createBridge(6, new TestBridgeNumberGenerator(newArrayList(1, 1, 0, 1, 0, 1)));
    }

    @DisplayName("플레이어가 한 라운드 플레이하면 게임 계속 가능 결과 반환")
    @Test
    void moveResultContinue() {
        GameStatus gameStatus = bridgeGame.move(1, "U");
        assertThat(gameStatus.isContinue()).isTrue();
    }

    @DisplayName("플레이어가 한 라운드 플레이하면 게임 실패 결과 반환")
    @Test
    void moveResultFail() {
        GameStatus gameStatus = bridgeGame.move(3, "U");
        assertThat(gameStatus.isFail()).isTrue();
    }

    @DisplayName("플레이어가 마지막 라운드 플레이하면 게임 성공 결과 반환")
    @Test
    void moveResultSuccess() {
        GameStatus gameStatus = bridgeGame.move(6, "U");
        assertThat(gameStatus.isSuccess()).isTrue();
    }

    @DisplayName("플레이어가 마지막 라운드 플레이하면 게임 실패 결과 반환")
    @Test
    void moveResultLastFail() {
        GameStatus gameStatus = bridgeGame.move(6, "D");
        assertThat(gameStatus.isFail()).isTrue();
    }

    @DisplayName("플레이어가 이동한 위치 기록 반환")
    @Test
    void getMoveReport() {
        bridgeGame.move(1, "U");
        bridgeGame.move(2, "U");
        bridgeGame.move(3, "D");

        GameResultDto responseDto = bridgeGame.getGameReport();

        assertThat(responseDto.getAttempt()).isEqualTo(1);
        assertThat(responseDto.getRecord())
                .containsExactly(BridgeMark.UP, BridgeMark.UP, BridgeMark.DOWN);
    }

    @DisplayName("게임 시도 횟수 반환")
    @Test
    void getGameAttempt() {
        bridgeGame.retry();
        bridgeGame.retry();

        GameResultDto responseDto = bridgeGame.getGameReport();
        assertThat(responseDto.getAttempt()).isEqualTo(3);
    }
}
