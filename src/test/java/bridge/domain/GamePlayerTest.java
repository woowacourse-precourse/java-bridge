package bridge.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GamePlayerTest {
    @Test
    void gameInitializationExceptionTest() {

        assertThatThrownBy(() -> {
            GamePlayer player = new GamePlayer();
            player.run();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith("[ERROR]");

    }

}