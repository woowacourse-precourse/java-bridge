package bridge.domain.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameCommandTypeTest {
    static Stream<Arguments> getResourceForValidGameCommand() {
        return Stream.of(
                Arguments.of("R", GameCommandType.RESTART),
                Arguments.of("Q", GameCommandType.QUIT)
        );
    }

    @ParameterizedTest
    @MethodSource("getResourceForValidGameCommand")
    @DisplayName("Command로 GameCommand를 찾아올 수 있는지 검사")
    void TestFindGameCommandByValidCommand(String command, GameCommandType gameCommandType) {
        assertThat(GameCommandType.findByCommand(command)).isEqualTo(gameCommandType);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "1"})
    @DisplayName("유효하지 않은 Command로 GameCommand를 탐색할 때 에러가 발생하는지 검사")
    void TestFindGameCommandByInvalidCommand(String command) {
        assertThatThrownBy(() -> GameCommandType.findByCommand(command)).isInstanceOf(IllegalArgumentException.class);
    }
}
