package bridge.domain.constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoveCommandsTest {

    @ParameterizedTest(name = "{0}을 입력 받으면 {1}를 반환한다.")
    @MethodSource("provideArgumentsForOf")
    void ofSuccess(String command, MoveCommands expected) {
        MoveCommands actual = MoveCommands.of(command);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "U, D가 아닌 다른 값을 입력 받으면 예외를 발생시킨다. 입력: {0}")
    @ValueSource(strings = {"R", "Q", "123", "U1", ""})
    void ofFail(String command) {
        assertThatThrownBy(() -> MoveCommands.of(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("U 또는 D만 입력해 주세요. (U:위, D:아래)");
    }

    @DisplayName("MoveCommand의 command 값과 입력 받은 String command 값이 같으면 true를 반환한다.")
    @Test
    void isForStringTrue() {
        MoveCommands moveUpCommand = MoveCommands.MOVE_UP_COMMAND;
        boolean actual = moveUpCommand.is("U");

        assertThat(actual).isTrue();
    }

    @DisplayName("MoveCommand의 command 값과 입력 받은 String command 값이 다르면 false를 반환한다.")
    @Test
    void isForStringFalse() {
        MoveCommands moveUpCommand = MoveCommands.MOVE_UP_COMMAND;
        boolean actual = moveUpCommand.is("D");

        assertThat(actual).isFalse();
    }

    @DisplayName("MoveCommand와 입력 받은 MoveCommand가 같으면 true를 반환한다.")
    @Test
    void isForMoveCommandTrue() {
        MoveCommands moveUpCommand = MoveCommands.MOVE_UP_COMMAND;
        boolean actual = moveUpCommand.is(MoveCommands.MOVE_UP_COMMAND);

        assertThat(actual).isTrue();
    }

    @DisplayName("MoveCommand와 입력 받은 MoveCommand가 다르면 false를 반환한다.")
    @Test
    void isForMoveCommandFalse() {
        MoveCommands moveUpCommand = MoveCommands.MOVE_UP_COMMAND;
        boolean actual = moveUpCommand.is(MoveCommands.MOVE_DOWN_COMMAND);

        assertThat(actual).isFalse();
    }

    private static Stream<Arguments> provideArgumentsForOf() {
        final String MOVE_UP_COMMAND_STRING = "U";
        final String MOVE_DOWN_COMMAND_STRING = "D";

        return Stream.of(
                Arguments.of(MOVE_UP_COMMAND_STRING, MoveCommands.MOVE_UP_COMMAND),
                Arguments.of(MOVE_DOWN_COMMAND_STRING, MoveCommands.MOVE_DOWN_COMMAND)
        );
    }
}