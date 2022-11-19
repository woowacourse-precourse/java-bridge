package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame = new BridgeGame();
    private Bridge bridge = new Bridge(List.of("U", "D", "U"));
    private User user = new User();

    @Test
    void move() {
        Assertions.assertThat(bridgeGame.move(0, "U", bridge, user)).isTrue();
        Assertions.assertThat(bridgeGame.move(1, "D", bridge, user)).isTrue();
        Assertions.assertThat(bridgeGame.move(2, "U", bridge, user)).isTrue();
    }

    @Test
    void retry(){
        Assertions.assertThat(bridgeGame.retry("R", user)).isTrue();
        Assertions.assertThat(bridgeGame.retry("Q",user)).isFalse();
    }
}