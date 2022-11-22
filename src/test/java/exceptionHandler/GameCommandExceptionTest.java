package exceptionHandler;

import enumCollections.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class GameCommandExceptionTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @DisplayName("빈 문자열을 입력했을 경우 예외처리 한다.")
    void 빈_문자열_입력_예외_테스트(String input) {
        assertThatThrownBy(() -> GameCommandException.validate(input))
                .hasMessage(ExceptionMessage.EMPTY_STRING.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "r", "q", "1"})
    @DisplayName("R 또는 Q가 아닌 경우 예외처리 한다.")
    void game_command가_아닌_경우_예외_테스트(String input) {
        assertThatThrownBy(() -> GameCommandException.validate(input))
                .hasMessage(ExceptionMessage.NOT_GAME_COMMAND.getMessage());
    }
}