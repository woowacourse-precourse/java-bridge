package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BridgeMoveCommandTest {
    @Test
    void getByOrderTest() {
        assertThat(BridgeMoveCommand.getByOrder(1)).isEqualTo(
                BridgeMoveCommand.MOVE_UP
        );
        assertThat(BridgeMoveCommand.getByOrder(0)).isEqualTo(
                BridgeMoveCommand.MOVE_DOWN
        );
    }

    @Test
    void getByCommandTest() {
        assertThat(BridgeMoveCommand.getByCommand("U")).isEqualTo(
                BridgeMoveCommand.MOVE_UP
        );
        assertThat(BridgeMoveCommand.getByCommand("D")).isEqualTo(
                BridgeMoveCommand.MOVE_DOWN
        );
    }
}
