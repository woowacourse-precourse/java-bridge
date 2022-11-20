package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void 이동_테스트() {
        BridgeGame game = new BridgeGame(5);
        game.move(1);
        game.move(1);
        game.move(1);
        game.move(0);
        game.move(1);

        assertThat(game.getUserSelect()).containsExactlyElementsOf(List.of("U", "U", "U", "D", "U"));
    }
}
