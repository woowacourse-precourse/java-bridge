package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeGame.STATE;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame game;

    @BeforeEach
    void init() {
        List<String> bridge = List.of("U", "D", "D", "U");
        game = new BridgeGame(bridge);
    }

    @Test
    void 정상_작동_테스트() {
        game.move("U");
        game.move("D");

        assertThat(game.getMoves()).isEqualTo(List.of("U", "D"));
        assertThat(game.getState()).isEqualTo(STATE.MOVING);
        assertThat(game.getRetries()).isEqualTo(1);
    }

    @Test
    void 실패_작동_테스트() {
        game.move("U");
        game.move("U");

        assertThat(game.getMoves()).isEqualTo(List.of("U", "U"));
        assertThat(game.getState()).isEqualTo(STATE.FAILED);
        assertThat(game.getRetries()).isEqualTo(1);
    }

    @Test
    void 완료_작동_테스트() {
        game.move("U");
        game.move("D");
        game.move("D");
        game.move("U");

        assertThat(game.getMoves()).isEqualTo(List.of("U", "D", "D", "U"));
        assertThat(game.getState()).isEqualTo(STATE.SUCCESS);
        assertThat(game.getRetries()).isEqualTo(1);
    }

    @Test
    void 재시도_테스트() {
        game.move("U");
        game.move("D");
        game.move("U");
        game.retry("R");


        assertThat(game.getMoves()).isEqualTo(List.of());
        assertThat(game.getState()).isEqualTo(STATE.MOVING);
        assertThat(game.getRetries()).isEqualTo(2);
    }
}