package bridge.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @Test
    @DisplayName("사용자의 이동 방향과 다리의 이동 가능 방향에 따라 움직인다.")
    void moving() {
        List<String> bridge = Arrays.asList("U", "D", "D", "U");
        BridgeGame game = new BridgeGame(bridge);

        assertThat(game.move("U")).isTrue();
        assertThat(game.move("U")).isFalse();
    }

}