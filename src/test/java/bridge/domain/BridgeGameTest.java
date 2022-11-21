package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void before() {
        bridgeGame = new BridgeGame(new Bridge(List.of("U")));
    }

    @DisplayName("사용자가 입력한 값에 따라 정답을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"RIGHT,UP", "WRONG,DOWN"})
    void finishTest(Answer answer, BridgeDirection direction) {
        Answer result = bridgeGame.move(direction);

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("게임이 끝나면 게임 상태를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"SUCCESS,UP", "FAIL,DOWN"})
    void gameStatus(GameStatus status,  BridgeDirection direction) {
        bridgeGame.move(direction);

        GameStatus result = bridgeGame.getStatus();

        assertThat(result).isEqualTo(status);
    }

    @DisplayName("게임이 끝나지 않으면 게임 중을 반환한다.")
    @Test
    void gameStatusPlaying() {
        GameStatus status = bridgeGame.getStatus();

        assertThat(status).isEqualTo(GameStatus.PLAYING);
    }

    @DisplayName("게임 시도 횟수를 반환한다.")
    @Test
    void gameTryCount() {
        int tryCount = bridgeGame.getTryCount();

        assertThat(tryCount).isEqualTo(1);
    }

    @DisplayName("게임 재시작을 하면 시도 횟수가 증가한다.")
    @Test
    void gameRetry() {
        bridgeGame.retry();

        int tryCount = bridgeGame.getTryCount();
        GameStatus status = bridgeGame.getStatus();

        assertThat(tryCount).isEqualTo(2);
        assertThat(status).isEqualTo(GameStatus.PLAYING);
    }
}