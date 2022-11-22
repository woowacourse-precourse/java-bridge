package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void move() {
        BridgeGame game = new BridgeGame();

        boolean result = game.move("U", List.of("U", "U"), new ArrayList<>());

        assertThat(result).isTrue();
    }

    @Test
    void retry() {
        BridgeGame game = new BridgeGame();

        boolean result = game.retry("R");

        assertThat(result).isTrue();
    }
}