package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static bridge.utils.ErrorMessages.ERROR_INVALID_GAME_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameCommandTest {

    @DisplayName("재시작 및 종료 여부 입력값을 객체로 생성한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void createGameCommandByInput(String input, GameCommand expect) {
        assertThat(GameCommand.of(input)).isEqualTo(expect);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of("R", GameCommand.RETRY),
            Arguments.of("Q", GameCommand.QUIT)
        );
    }

    @DisplayName("재시작 및 종료 여부 입력값이 U 또는 D가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"sky", "A", "r", "q", "1"})
    void createGameCommandByInput(String input) {
        assertThatThrownBy(() -> GameCommand.of(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_INVALID_GAME_COMMAND);
    }

    @DisplayName("재시작 여부를 확인한다.")
    @ParameterizedTest
    @MethodSource("generateDataByIsRetry")
    void isRetryTest(GameCommand gameCommand, boolean expect) {
        assertThat(gameCommand.isRetry()).isEqualTo(expect);
    }

    static Stream<Arguments> generateDataByIsRetry() {
        return Stream.of(
            Arguments.of(GameCommand.RETRY, true),
            Arguments.of(GameCommand.QUIT, false)
        );
    }
}
