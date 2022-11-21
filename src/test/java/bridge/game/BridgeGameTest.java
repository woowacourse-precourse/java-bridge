package bridge.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    //move()
    @Test
    @DisplayName("정지 상태에서 추가 move 시 예외처리")
    void testExceptionAtWrongMoveAgain() {
        BridgeGame game = new BridgeGame(List.of("U", "D", "D"));
        game.move("U");
        game.move("U");

        assertThatThrownBy(() -> game.move("U"))
                .isInstanceOf(IllegalStateException.class);
    }

    //progress()
    @Test
    @DisplayName("생성시 빈 진행 상황")
    void testProgressAtConstruct() {
        BridgeGame game = new BridgeGame(List.of("U", "D", "D"));

        assertThat(game.progressMap()).isEqualTo(List.of(List.of(), List.of()));
    }

    //status()
    @Test
    @DisplayName("생성시 상태 = 진행중")
    void testStatusAtConstruct() {
        BridgeGame game = new BridgeGame(List.of("U", "D", "D"));

        assertThat(game.status()).isEqualTo(BridgeGameStatus.RUNNING);
    }

    @Test
    @DisplayName("오답시 상태 = 중단")
    void testStatusAtWrong() {
        BridgeGame game = new BridgeGame(List.of("U", "D", "D"));
        game.move("U");
        game.move("U");

        assertThat(game.status()).isEqualTo(BridgeGameStatus.STOP);
    }

    @Test
    @DisplayName("재시작 상태")
    void testStatusAtRetry() {
        BridgeGame game = new BridgeGame(List.of("U", "D", "D"));
        game.retry();

        assertThat(game.status()).isEqualTo(BridgeGameStatus.RUNNING);
    }

    @Test
    @DisplayName("오답에서 재시작 상태")
    void testStatusAtWrongToRetry() {
        BridgeGame game = new BridgeGame(List.of("U", "D", "D"));
        game.retry();

        assertThat(game.status()).isEqualTo(BridgeGameStatus.RUNNING);
    }


}