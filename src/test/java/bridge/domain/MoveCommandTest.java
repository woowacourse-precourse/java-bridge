package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {

    @Test
    void 문자_U_혹은_D_전달하여_생성() {
        //given
        //when
        MoveCommand moveCommand = MoveCommand.of('U');
        //then
        assertThat(moveCommand).isEqualTo(MoveCommand.UP);
    }

    @Test
    void 문자_U_혹은_D_아니면_예외발생() {
        assertThatThrownBy(() -> MoveCommand.of('a'))
                .isInstanceOf(IllegalArgumentException.class);
    }
}