package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private Bridge bridge;
    private User user;
    private Result result;

    private BridgeGame bridgeGame;


    @BeforeEach
    void init() {
        bridge = new Bridge(List.of("U", "D", "D"), 3);
        user = new User();
        result = new Result();
        bridgeGame = new BridgeGame(bridge, user, result);
    }

    @DisplayName("제대로 다리를 건너는 경우 확인")
    @Test
    void moveCorrect() {
        boolean moving = bridgeGame.move("U");
        assertTrue(moving);
        assertThat(user.getPosition()).isEqualTo(1);
        assertThat(result.getUp().get(0)).isEqualTo("O");
        assertThat(result.getDown().get(0)).isEqualTo(" ");
    }

    @DisplayName("잘못 다리를 건너는 경우 확인")
    @Test
    void moveIncorrect() {
        boolean moving = bridgeGame.move("D");
        assertFalse(moving);
        assertThat(user.getPosition()).isEqualTo(0);
        assertThat(result.getUp().get(0)).isEqualTo(" ");
        assertThat(result.getDown().get(0)).isEqualTo("X");
    }

    @DisplayName("다리를 한 번 건넌 후 재시도하는 경우 결과가 초기화되는지 확인")
    @Test
    void retry() {
        bridgeGame.move("D");
        bridgeGame.retry();
        assertThat(user.getPosition()).isEqualTo(0);
        assertThat(result.getUp().size()).isEqualTo(0);
        assertThat(result.getDown().size()).isEqualTo(0);
        assertThat(result.getNumberOfTrial()).isEqualTo(2);
    }

    @DisplayName("다리를 모두 건넌 후 더 이상 이동할 수 없는 지 확인")
    @Test
    void isLastMoving() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertTrue(bridgeGame.isLastMoving());
        assertTrue(result.getIsSuccess());
    }

    @DisplayName("게임이 끝난 후 게임이 진행중인지 확인")
    @Test
    void isOver() {
        bridgeGame.isOver();
        assertFalse(bridgeGame.getIsRunning());
    }
}