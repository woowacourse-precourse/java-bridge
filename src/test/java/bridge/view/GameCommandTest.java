package bridge.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCommandTest {

    @Test
    void willRestart() {
        assertThat(GameCommand.willRestart("R")).isTrue();
        assertThat(GameCommand.willRestart("Q")).isFalse();
    }

    @Test
    void willRestartException() {
        assertThatThrownBy(() -> GameCommand.willRestart("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}