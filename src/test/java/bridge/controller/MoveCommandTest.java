package bridge.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static bridge.controller.MoveCommand.DOWN;
import static bridge.controller.MoveCommand.UP;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoveCommandTest {
    @DisplayName("지정된 값을 넘겨주면 command 가 반환된다")
    @Test
    void parseValueToCommand() {
        String upCommand = MoveCommand.parseValueToCommand(UP.getValue());
        String downCommand = MoveCommand.parseValueToCommand(DOWN.getValue());

        Assertions.assertThat(upCommand).isEqualTo(UP.getCommand());
        Assertions.assertThat(downCommand).isEqualTo(DOWN.getCommand());
    }

    @DisplayName("지정되지 않은 값을 넘겨주면 예외가 발생한다.")
    @Test
    void parseValueToCommandFail() {
        assertThatThrownBy(() -> MoveCommand.parseValueToCommand(UP.getValue() + 1230))
                .isInstanceOf(NoSuchElementException.class);
    }
}