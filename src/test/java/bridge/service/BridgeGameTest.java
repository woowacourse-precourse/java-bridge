package bridge.service;

import bridge.enums.BridgeMark;
import bridge.enums.GameStatus;
import bridge.TestBridgeNumberGenerator;
import bridge.dto.GameResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.dto.GameResultDto.GameRecordDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        bridgeGame.createBridge(6, new TestBridgeNumberGenerator(newArrayList(1, 1, 0, 1, 0, 1)));
    }

    @DisplayName("플레이어가 한 라운드 플레이 후 게임 계속 가능 결과 확인")
    @Test
    void moveResultContinue() {
        GameResultDto gameResultDto = bridgeGame.move(1, "U");
        GameStatus gameStatus = gameResultDto.getGameStatus();
        assertThat(gameStatus.isContinue()).isTrue();
    }

    @DisplayName("플레이어가 한 라운드 플레이 후 게임 실패 결과 확인")
    @Test
    void moveResultFail() {
        GameResultDto gameResultDto = bridgeGame.move(3, "U");
        GameStatus gameStatus = gameResultDto.getGameStatus();
        assertThat(gameStatus.isFail()).isTrue();
    }

    @DisplayName("플레이어가 마지막 라운드 플레이 후 게임 성공 결과 확인")
    @Test
    void moveResultSuccess() {
        GameResultDto gameResultDto = bridgeGame.move(6, "U");
        GameStatus gameStatus = gameResultDto.getGameStatus();
        assertThat(gameStatus.isSuccess()).isTrue();
    }

    @DisplayName("플레이어가 마지막 라운드 플레이 후 게임 실패 결과 확인")
    @Test
    void moveResultLastFail() {
        GameResultDto gameResultDto = bridgeGame.move(6, "D");
        GameStatus gameStatus = gameResultDto.getGameStatus();
        assertThat(gameStatus.isFail()).isTrue();
    }

    @DisplayName("플레이어가 이동한 위치 기록 확인")
    @Test
    void getMoveReport() {
        bridgeGame.move(1, "U");
        bridgeGame.move(2, "U");
        GameResultDto gameResultDto = bridgeGame.move(3, "D");

        GameRecordDto gameRecord = gameResultDto.getGameRecord();

        assertThat(gameRecord.getAttempt()).isEqualTo(1);
        assertThat(gameRecord.getRecord())
                .containsExactly(BridgeMark.UP, BridgeMark.UP, BridgeMark.DOWN);
    }

    @DisplayName("게임 재시작 후 시도 횟수 확인")
    @Test
    void getGameAttempt() {
        bridgeGame.retry();
        bridgeGame.retry();

        GameResultDto gameResultDto = bridgeGame.move(3, "D");
        GameRecordDto gameRecord = gameResultDto.getGameRecord();

        assertThat(gameRecord.getAttempt()).isEqualTo(3);
    }
}
