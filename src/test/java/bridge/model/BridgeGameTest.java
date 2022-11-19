package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    private static final int INITIAL_PLAY_COUNT = 1;

    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame(List.of("U", "U", "U"));
    }

    @DisplayName("게임이 시작하면 시도 횟수는 1회부터 시작한다.")
    @Test
    void startGame() {
        assertThat(bridgeGame.getPlayCount()).isEqualTo(INITIAL_PLAY_COUNT);
    }

    @DisplayName("다리를 한칸 건너는데 성공하면 MoveResult.SUCCESS 를 반환한다.")
    @Test
    void move() {
        assertThat(bridgeGame.move(Direction.U)).isEqualTo(MoveResult.SUCCESS);
    }

    @DisplayName("다리를 한칸 건너는데 실패하면 MoveResult.FAIL 을 반환한다.")
    @Test
    void moveFail() {
        assertThat(bridgeGame.move(Direction.D)).isEqualTo(MoveResult.FAIL);
    }

    @DisplayName("재시작 커맨드를 누르면 게임을 계속 진행한다.")
    @Test
    void retry() {
        bridgeGame.inputCommand(GameCommand.RETRY);
        assertThat(bridgeGame.canPlay()).isTrue();
    }

    @DisplayName("재시작 커맨드를 누르면 플레이어 위치가 처음으로 돌아가고 시도 횟수가 1회 증가한다.")
    @Test
    void pressRetryCommandResult() {
        int initialPosition = 0;
        int initialPlayCount = bridgeGame.getPlayCount();
        int positionAfterOneMove = 1;

        assertThat(bridgeGame.getPlayer().getPosition()).isEqualTo(initialPosition);
        bridgeGame.move(Direction.U);
        assertThat(bridgeGame.getPlayer().getPosition()).isEqualTo(positionAfterOneMove);

        bridgeGame.inputCommand(GameCommand.RETRY);
        assertThat(bridgeGame.getPlayCount()).isEqualTo(initialPlayCount + 1);
        assertThat(bridgeGame.getPlayer().getPosition()).isEqualTo(initialPosition);
    }

    @DisplayName("게임종료 커맨드를 누르면 게임을 종료한다.")
    @Test
    void quit() {
        bridgeGame.inputCommand(GameCommand.QUIT);
        assertThat(bridgeGame.canPlay()).isFalse();
    }

    @DisplayName("플레이어가 다리를 다 건너면 게임을 종료한다.")
    @Test
    void gameCleared() {
        bridgeGame.move(Direction.U);
        bridgeGame.checkGameCleared();
        assertThat(bridgeGame.canPlay()).isTrue();

        bridgeGame.move(Direction.U);
        bridgeGame.checkGameCleared();
        assertThat(bridgeGame.canPlay()).isTrue();

        bridgeGame.move(Direction.U);
        bridgeGame.checkGameCleared();
        assertThat(bridgeGame.canPlay()).isFalse();
    }
}
