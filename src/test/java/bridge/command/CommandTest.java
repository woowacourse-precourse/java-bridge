package bridge.command;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandTest {

    @Test
    @DisplayName("GameCommand의 exist 메소드 확인")
    void checkExistMethodInGameCommand() {
        assertAll(
                () -> assertThat(GameCommand.exist("R")).isEqualTo(true),
                () -> assertThat(GameCommand.exist("Q")).isEqualTo(true),
                () -> assertThat(GameCommand.exist("H")).isEqualTo(false),
                () -> assertThat(GameCommand.exist("U")).isEqualTo(false)
        );
    }

    @Test
    @DisplayName("MoveCommand의 exist 메소드 확인")
    void checkExistMethodInMoveCommand() {
        assertAll(
                () -> assertThat(MoveCommand.exist("U")).isEqualTo(true),
                () -> assertThat(MoveCommand.exist("D")).isEqualTo(true),
                () -> assertThat(MoveCommand.exist("u")).isEqualTo(false),
                () -> assertThat(MoveCommand.exist("i")).isEqualTo(false)
        );
    }

}