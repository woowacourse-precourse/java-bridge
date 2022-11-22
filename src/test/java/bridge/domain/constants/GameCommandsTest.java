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

class GameCommandsTest {

    @ParameterizedTest(name = "{0}을 입력 받으면 {1}를 반환한다.")
    @MethodSource("provideArgumentsForOf")
    void ofSuccess(String command, GameCommands expected) {
        GameCommands actual = GameCommands.of(command);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "R, Q가 아닌 다른 값을 입력 받으면 예외를 발생시킨다. 입력: {0}")
    @ValueSource(strings = {"U", "D", "123", "Q1", ""})
    void ofFail(String command) {
        assertThatThrownBy(() -> GameCommands.of(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("R 또는 Q만 입력해 주세요. (R:재시작, Q:종료)");
    }

    @DisplayName("서로 같은 GameCommands면 True를 반환한다.")
    @Test
    void isReturnTrue() {
        GameCommands gameCommands = GameCommands.RETRY;
        assertThat(gameCommands.is(GameCommands.RETRY)).isTrue();
    }

    @DisplayName("서로 GameCommands가 아니면 False를 반환한다.")
    @Test
    void isReturnFalse() {
        GameCommands gameCommands = GameCommands.RETRY;
        assertThat(gameCommands.is(GameCommands.QUIT)).isFalse();
    }

    private static Stream<Arguments> provideArgumentsForOf() {
        return Stream.of(
                Arguments.of("R", GameCommands.RETRY),
                Arguments.of("Q", GameCommands.QUIT)
        );
    }
}