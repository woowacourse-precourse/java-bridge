package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.List;


class BridgeGameTest {
    BridgeGame game = new BridgeGame(List.of("U", "U", "U", "D"));

    @Test
    void move_맞았을때() {
        assertThat(game.move("U")).isEqualTo(true);
    }

    @Test
    void move_틀렸을때() {
        assertThat(game.move("D")).isEqualTo(false);
    }

    @Test
    void 현재_건너온_다리() {
        game.move("U");
        game.move("D");
        List<String> expectedState = List.of("U", "D");
        assertThat(game.getCrossedBridge()).isEqualTo(expectedState);
    }

    @Test
    void 리트라이() {
        game.move("U");
        game.move("D");
        List<String> expectedState = List.of("U", "D");
        assertThat(game.getCrossedBridge()).isEqualTo(expectedState);
        game.retry();
        assertThat(game.getCrossedBridge()).isEqualTo(List.of());
    }

}