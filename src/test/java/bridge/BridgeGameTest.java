package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    @DisplayName("이동하려는 칸이 'U'나 'D'가 아닐 경우 예외 처리한다. (Case 1)")
    @Test
    void invalidMoveCase1() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThatThrownBy(() -> bridgeGame.move("X"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동하려는 칸이 'U'나 'D'가 아닐 경우 예외 처리한다. (Case 2)")
    @Test
    void invalidMoveCase2() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThatThrownBy(() -> bridgeGame.move("123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동하려는 칸이 'U'나 'D'가 아닐 경우 예외 처리한다. (Case 3)")
    @Test
    void invalidMoveCase3() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThatThrownBy(() -> bridgeGame.move("u"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 경우 이동 진행 상태가 추가가 되어야 한다. - 1")
    @Test
    void validMoveCase1() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThat(bridgeGame.move("U")).isEqualTo(true);
    }

    @DisplayName("정상적인 경우 이동 진행 상태가 추가가 되어야 한다. - 2")
    @Test
    void validMoveCase2() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.getUserPath()).isEqualTo(List.of("U", "D"));
    }

    @DisplayName("게임 종료 조건 (게임 성공) 시 이동이 되어선 안된다.")
    @Test
    void invalidMoveAfterGameOverWin() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThat(bridgeGame.move("U")).isEqualTo(true);
        assertThat(bridgeGame.move("D")).isEqualTo(true);
        assertThat(bridgeGame.move("D")).isEqualTo(true);
        assertThat(bridgeGame.move("U")).isEqualTo(false);
    }

    @DisplayName("게임 종료 조건 (게임 실패) 시 이동이 되어선 안된다.")
    @Test
    void invalidMoveAfterGameOverLose() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThat(bridgeGame.move("U")).isEqualTo(true);
        assertThat(bridgeGame.move("U")).isEqualTo(true);
        assertThat(bridgeGame.move("U")).isEqualTo(false);
    }

    @DisplayName("잘못된 이동 시도들이 추가가 되어선 안된다.")
    @Test
    void userPathAfterInvalidMoveAttempts() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U"); // 패배, 마지막 이동이 되어야 함.
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.getUserPath()).isEqualTo(List.of("U", "D", "U"));
    }

    @DisplayName("게임 승리 시 게임 진행 상태가 적절하게 바뀌어야 한다.")
    @Test
    void gameStatusWinAfterCorrectMoves() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.getGameStatus()).isEqualTo(GameStatus.WIN);
    }

    @DisplayName("게임 패배 시 게임 진행 상태가 적절하게 바뀌어야 한다.")
    @Test
    void gameStatusLoseAfterIncorrectMoves() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.getGameStatus()).isEqualTo(GameStatus.LOSE);
    }

    @DisplayName("게임이 종료되기 전까지 게임 진행 상태는 '진행중'을 나타내야 한다.")
    @Test
    void gameStatusOngoingWhenGameNotOver() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.getGameStatus()).isEqualTo(GameStatus.ONGOING);
    }

    @DisplayName("게임 재시도 시 이동 진행 상태가 초기화되어야 한다.")
    @Test
    void clearUserPathWhenRetry() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("D");
        bridgeGame.retry();
        assertThat(bridgeGame.getUserPath().isEmpty()).isEqualTo(true);
    }

    @DisplayName("게임 재시도 시 게임 진행 상태가 초기화되어야 한다.")
    @Test
    void resetGameStatusToOngoingWhenRetry() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("D");
        assertThat(bridgeGame.getGameStatus()).isEqualTo(GameStatus.LOSE);
        bridgeGame.retry();
        assertThat(bridgeGame.getGameStatus()).isEqualTo(GameStatus.ONGOING);
    }

    @DisplayName("게임 재시도 시 시도 횟수가 증가되어야 한다.")
    @Test
    void incrementTryCountWhenRetry() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("D");
        assertThat(bridgeGame.getTryCount()).isEqualTo(1);
        bridgeGame.retry();
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
    }
}
