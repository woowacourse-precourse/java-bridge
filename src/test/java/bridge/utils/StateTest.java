package bridge.utils;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @Test
    void of_up() {
        State state = State.of(1);

        assertThat(state).isEqualTo(State.UP);
    }
    @Test
    void of_down() {
        State state = State.of(0);

        assertThat(state).isEqualTo(State.DOWN);
    }
}