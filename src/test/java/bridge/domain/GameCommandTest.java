package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameCommandTest {

    @DisplayName("\"R\"과 \"Q\"로 GameCommand객체 찾기")
    @ParameterizedTest
    @MethodSource("provideExpressions")
    void findByExpression(String expression, GameCommand expected) {
        Optional<GameCommand> actual = GameCommand.findByExpression(expression);
        actual.ifPresent(gameCommand -> assertThat(gameCommand).isEqualTo(expected));
    }

    private static Stream<Arguments> provideExpressions() {
        return Stream.of(
                Arguments.of(Named.of("\"R\"", "R"),
                        Named.of(GameCommand.RETRY.name(), GameCommand.RETRY)),
                Arguments.of(Named.of("\"Q\"", "Q"),
                        Named.of(GameCommand.QUIT.name(), GameCommand.QUIT))
        );
    }
}