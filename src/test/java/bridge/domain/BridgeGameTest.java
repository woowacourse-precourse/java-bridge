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

    @Test
    void retry() {
    }

    @Test
    void isLastMoving() {
    }

    @Test
    void isOver() {
    }
}