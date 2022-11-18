package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "D")), new User());

    @Test
    void move() {
        Assertions.assertThat(bridgeGame.move(0, "U")).isTrue();
        Assertions.assertThat(bridgeGame.move(1, "D")).isTrue();
        Assertions.assertThat(bridgeGame.move(2, "U")).isFalse();
    }

    @Test
    void retry(){
        Assertions.assertThat(bridgeGame.retry("R")).isTrue();
        Assertions.assertThat(bridgeGame.retry("Q")).isFalse();
    }
}