package bridge.domain.command;

import bridge.domain.direction.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {

    @DisplayName("이동 명령어를 방향으로 매핑한다.")
    @Test
    void mapCommandToDirection() {
        // given
        String upCommand = "U";
        String downCommand = "D";

        // when
        MoveCommand up = MoveCommand.of(upCommand);
        MoveCommand down = MoveCommand.of(downCommand);

        // then
        assertThat(up).isEqualTo(MoveCommand.MOVE_UP);
        assertThat(down).isEqualTo(MoveCommand.MOVE_DOWN);
    }
}