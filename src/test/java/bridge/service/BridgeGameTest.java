package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.domain.BridgeCellType;
import bridge.domain.GameCommand;
import bridge.domain.MoveResult;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    @DisplayName("해당 위치의 입력된 이동 타입과 다리의 상태가 같으면 move 는 성공한다.")
    void moveSuccess() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "U"), new MoveResult());

        // when
        bridgeGame.move(0, BridgeCellType.DOWN);

        // then
        assertThat(bridgeGame.getMoveResult().isSuccess()).isTrue();
    }

    @Test
    @DisplayName("해당 위치의 입력된 이동 타입과 다리의 상태가 다르면 move 는 실패한다.")
    void moveFail() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "U"), new MoveResult());

        // when
        bridgeGame.move(0, BridgeCellType.UP);

        // then
        assertThat(bridgeGame.getMoveResult().isSuccess()).isFalse();
    }

    @Test
    @DisplayName("다리의 범위를 벗어난 위치의 이동은 예외가 발생한다.")
    void invalidMove() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "U"), new MoveResult());

        // then
        assertThrows(IllegalArgumentException.class, () -> bridgeGame.move(2, BridgeCellType.UP));
    }

    @Test
    @DisplayName("재시작 시 시도 횟수를 증가하고 이동 내역은 초기화 한다.")
    void retry() {
        // given
        MoveResult moveResult = new MoveResult();
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "U"), moveResult);
        int initTryCount = moveResult.getTryCount();
        bridgeGame.move(0, BridgeCellType.DOWN);

        // when
        bridgeGame.retry(GameCommand.RETRY);
        Map<BridgeCellType, List<String>> moveHistory = bridgeGame.getMoveResult()
            .getMoveHistory();

        // then
        assertThat(bridgeGame.getMoveResult().getTryCount()).isEqualTo(initTryCount + 1);
        moveHistory.values().forEach(value -> assertThat(value).isEmpty());
    }

    @Test
    @DisplayName("종료 입력 시 종료 커맨드를 반환한다.")
    void quit() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "U"), new MoveResult());

        // when
        GameCommand command = bridgeGame.retry(GameCommand.QUIT);

        // then
        assertThat(command).isEqualTo(GameCommand.QUIT);
    }

}